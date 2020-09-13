package net.projecteuler.aurrix.pockerhands.hands.ranks;

import net.projecteuler.aurrix.pockerhands.hands.Hand;

import java.util.Collections;

public interface Rank extends Comparable<Rank> {
    boolean checks(Hand hand);

    int getHandScore(Hand hand);

    int getRuleOrder();

    String getName();

    default int compareTo(Rank rank) {
        return rank.getRuleOrder() < getRuleOrder() ? 1 : -1;
    }

    default void sortCardsByValue(Hand hand) {
        Collections.sort(hand.getCards());
    }
}
