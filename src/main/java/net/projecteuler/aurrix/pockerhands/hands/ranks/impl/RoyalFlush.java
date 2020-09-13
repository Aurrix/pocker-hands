package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

@Service
public class RoyalFlush implements Rank {

    public static final String NAME = "Royal Flush";

    private final Flush flush;

    public RoyalFlush(Flush flush) {
        this.flush = flush;
    }

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size()!=5) return false;
        boolean royal = true;
        int expectedValue = 9; // ++
        for (Card card : hand.getCards()) {
            if (card.getValue().value != ++expectedValue) royal = false;
        }
        return royal && flush.checks(hand);
    }

    @Override
    public int getHandScore(Hand hand) {
        return 9000;
    }

    @Override
    public int getRuleOrder() {
        return 1;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
