package net.projecteuler.aurrix.pockerhands;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.services.RankingService;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@SpringBootApplication
public class PokerHandsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PokerHandsApplication.class, args);

        RankingService rankingService = context.getBean(RankingService.class);

        List<String> data = loadData(args);

        Map<String, Card> cardMap = getCardSignatureMap();

        int player1 = 0;
        int player2 = 0;

        for (String line : data) {

            int roundPlayer1Score;
            int roundPlayer2Score;

            List<Card> player1Cards = new ArrayList<>();
            List<Card> player2Cards = new ArrayList<>();

            List<String> cards = Arrays.asList(line.split(" "));

            for (int i = 0; i < 5; i++) {
                player1Cards.add(cardMap.get(cards.get(i)));
            }
            Hand player1Hand = new Hand(player1Cards);
            roundPlayer1Score = rankingService.rankHand(player1Hand);

            for (int i = 5; i < 10; i++) {
                player2Cards.add(cardMap.get(cards.get(i)));
            }
            Hand player2Hand = new Hand(player2Cards);
            roundPlayer2Score = rankingService.rankHand(player2Hand);

            if (roundPlayer1Score > roundPlayer2Score) player1++;
            else player2++;

            System.out.println(player1Hand + " (" + roundPlayer1Score + ")" + (roundPlayer1Score == roundPlayer2Score ? "==" : " VS ") + player2Hand + " (" + roundPlayer2Score + ")");
        }
        System.out.println("Player 1 wins: " + player1);
        System.out.println("Player 2 wins: " + player2);
    }

    private static Map<String, Card> getCardSignatureMap() {
        Map<String, Card> result = new HashMap<>();
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values())
                result.put(value.character + suit.letter, new Card(suit, value));
        }
        return result;
    }

    private static List<String> loadData(String[] args) {
        List<String> data = new ArrayList<>();
        try {
            if (args.length == 0) data = Files.readAllLines(new ClassPathResource("example.txt").getFile().toPath());
            else data = Files.readAllLines(new File(args[0]).toPath());
        } catch (IOException e) {
            System.out.println("Cannot load default or specified file");
            System.exit(1);
        }
        return data;
    }

}
