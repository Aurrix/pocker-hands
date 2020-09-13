package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Straight implements Rank {

    public static final String NAME = "Straight";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size()!=5) return false;
        boolean consecutive = true;
        int previous = 0;
        for (Card card : hand.getCards()) {
            if (previous != 0 && card.getValue().value != ++previous) consecutive = false;
            if (previous == 0) previous = card.getValue().value;
        }
        return consecutive;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 4000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 6;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
