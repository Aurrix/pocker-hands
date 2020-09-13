package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Flush implements Rank {

    public static final String NAME = "Flush";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        String previous = "";
        for (Card card : hand.getCards()) {
            if (previous.isEmpty()) previous = card.getSuit().letter;
            if (!previous.equals(card.getSuit().letter)) return false;
        }
        return true;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 5000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 5;
    }

    @Override
    public String getName() {
        return NAME;
    }


}
