package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullHouse implements Rank {

    public static final String NAME = "Full house";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size() != 5) return false;

        List<Card> cards = hand.getCards();
        boolean result = false;

        if (cards.get(0).getValue().value == cards.get(1).getValue().value &&
                cards.get(2).getValue().value == cards.get(3).getValue().value &&
                cards.get(3).getValue().value == cards.get(4).getValue().value ||
                cards.get(0).getValue().value == cards.get(1).getValue().value &&
                        cards.get(1).getValue().value == cards.get(2).getValue().value &&
                        cards.get(3).getValue().value == cards.get(4).getValue().value) result = true;

        return result;

    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 6000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 4;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
