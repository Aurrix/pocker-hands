package net.projecteuler.aurrix.pockerhands.hands.cards.services;

import net.projecteuler.aurrix.pockerhands.hands.Hand;

public interface RankingService {
    int rankHand(Hand hand);
    int getHighestCardValue(Hand hand);
}
