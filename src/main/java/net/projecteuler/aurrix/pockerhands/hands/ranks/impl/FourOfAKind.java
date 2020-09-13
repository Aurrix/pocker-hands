package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

@Service
public class FourOfAKind implements Rank {

    public static final String NAME = "Four of a Kind";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size()!=5) return false;

        int previous = 0;
        int occCount = 0;
        for (Card card : hand.getCards()) {
            if (previous == card.getValue().value && occCount >= 2) return true;
            if (previous == card.getValue().value) {
                occCount++;
            } else occCount = 0;
            previous = card.getValue().value;
        }
        return false;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 7000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 3;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
