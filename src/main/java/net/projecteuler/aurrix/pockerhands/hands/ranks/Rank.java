package net.projecteuler.aurrix.pockerhands.hands.ranks;

import net.projecteuler.aurrix.pockerhands.hands.Hand;

import java.util.Collections;

public interface Rank extends Comparable {
    boolean checks(Hand hand);

    int getHandScore(Hand hand);

    int getRuleOrder();

    String getName();

    default int compareTo(Object o) {
        if (o instanceof Rank) {
            Rank rank = (Rank) o;
            return rank.getRuleOrder() < getRuleOrder() ? 1 : -1;
        }
        return 0;
    }

    default void sortCardsByValue(Hand hand) {
        Collections.sort(hand.getCards());
    }
}
