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
                        new Card(Suit.DIAMOND, Value.TWO),
                        new Card(Suit.DIAMOND, Value.THREE),
                        new Card(Suit.DIAMOND, Value.FOUR),
                        new Card(Suit.DIAMOND, Value.FIVE),
                        new Card(Suit.DIAMOND, Value.SIX)
                ))));
    }

    @Test
    public void checksFalse() {
        StraightFlush straightFlush = new StraightFlush();
        assertFalse(straightFlush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.HEART, Value.NINE),
                        new Card(Suit.HEART, Value.TEN),
                        new Card(Suit.HEART, Value.JACK),
                        new Card(Suit.HEART, Value.QUEEN),
                        new Card(Suit.DIAMOND, Value.KING)
                ))));
    }
}