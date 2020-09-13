package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

@Service
public class TwoPairs implements Rank {

    public static final String NAME = "Two Pairs";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size()!=5) return false;
        int previous = 0;
        int firstPair = 0;
        for (Card card : hand.getCards()) {
            if (card.getValue().value == previous && firstPair != 0) return true;
            else if (card.getValue().value == previous) firstPair = card.getValue().value;
            else previous = card.getValue().value;
        }
        return false;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 2000;
        for (Card card : hand.getCards()) {
            score += card.getValue().value;
        }
        return score;
    }

    @Override
    public int getRuleOrder() {
        return 8;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
