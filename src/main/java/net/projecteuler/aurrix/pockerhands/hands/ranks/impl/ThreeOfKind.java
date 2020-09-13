package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

@Service
public class ThreeOfKind implements Rank {

    public static final String NAME = "Three of a Kind";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size()!=5) return false;

        int previous = 0;
        int occCount = 0;
        for (Card card : hand.getCards()) {
            if (previous == card.getValue().value) {
                occCount++;
            } else occCount = 0;
            if (previous == card.getValue().value && occCount > 1) return true;
            previous = card.getValue().value;
        }
        return false;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 3000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 7;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
