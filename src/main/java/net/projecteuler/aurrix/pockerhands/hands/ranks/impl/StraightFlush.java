package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

@Service
public class StraightFlush implements Rank {

    public static final String NAME = "Straight flush";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size()!=5) return false;
        boolean consecutive = true;
        int previous = 0;
        String suit = "";
        for (Card card : hand.getCards()) {
            if ((previous != 0 && card.getValue().value != ++previous) || (!suit.equals(card.getSuit().letter) && !suit.isEmpty()))
            consecutive = false;
            if (previous == 0) previous = card.getValue().value;
            if (suit.isEmpty()) suit = card.getSuit().letter;

        }
        return consecutive;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 8000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 2;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Rank) {
            Rank rank = (Rank) o;
            return rank.getRuleOrder() < getRuleOrder() ? 1 : -1;
        }
        return 0;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
