package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StraightFlushTest {
    @Test
    public void checksTrue() {
        StraightFlush straightFlush = new StraightFlush();
        assertTrue(straightFlush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Diamond, Value.Two),
                        new Card(Suit.Diamond, Value.Three),
                        new Card(Suit.Diamond, Value.Four),
                        new Card(Suit.Diamond, Value.Five),
                        new Card(Suit.Diamond, Value.Six)
                ))));
    }

    @Test
    public void checksFalse() {
        StraightFlush straightFlush = new StraightFlush();
        assertFalse(straightFlush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Heart, Value.Nine),
                        new Card(Suit.Heart, Value.Ten),
                        new Card(Suit.Heart, Value.Jack),
                        new Card(Suit.Heart, Value.Queen),
                        new Card(Suit.Diamond, Value.King)
                ))));
    }
}