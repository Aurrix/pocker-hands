package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnePairTest {

    @Test
    public void checksTrue() {
        OnePair onePair = new OnePair();
        assertTrue(onePair.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Three),
                        new Card(Suit.Diamond, Value.Eight)
                ))));
    }

    @Test
    public void checksFalse() {
        OnePair onePair = new OnePair();
        assertFalse(onePair.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Queen),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Three),
                        new Card(Suit.Diamond, Value.Eight)
                ))));
    }

    @Test
    public void getHandScore() {
    }
}