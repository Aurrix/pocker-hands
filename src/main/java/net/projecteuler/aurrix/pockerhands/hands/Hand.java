package net.projecteuler.aurrix.pockerhands.hands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;

import java.util.List;

@Getter
@Setter
public class Hand {
    private String rank = "Highest Card Value";
    private int score;
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return rank + " " + cards.toString();
    }
}
