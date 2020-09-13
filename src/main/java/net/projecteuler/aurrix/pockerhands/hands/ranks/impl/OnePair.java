package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnePair implements Rank {

    public static final String NAME = "One Pair";

    @Override
    public boolean checks(Hand hand) {
        Rank.super.sortCardsByValue(hand);
        if (hand.getCards().size() != 5) return false;


        int previous = 0;
        for (Card card : hand.getCards()) {
            if (previous == card.getValue().value) return true;
            else previous = card.getValue().value;
        }
        return false;
    }

    @Override
    public int getHandScore(Hand hand) {
        int score = 1000;
        int matched = 0;
        int highest = 0;
        List<Card> cards = hand.getCards();
        for (int i = 0; i < 5; i++) {
            if (i != 0 && cards.get(i).getValue().value == cards.get(i - 1).getValue().value) {
                score += cards.get(i).getValue().value * 10;
                matched = cards.get(i).getValue().value;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (highest < cards.get(i).getValue().value && cards.get(i).getValue().value != matched)
                highest = cards.get(i).getValue().value;
        }
        return score + highest;
    }

    @Override
    public int getRuleOrder() {
        return 9;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
