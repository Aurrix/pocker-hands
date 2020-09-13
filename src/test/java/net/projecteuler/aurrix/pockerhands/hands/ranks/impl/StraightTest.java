package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

    @Test
    public void checksTrue() {
        Straight straight = new Straight();
        assertTrue(straight.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.THREE),
                        new Card(Suit.DIAMOND, Value.FOUR),
                        new Card(Suit.HEART, Value.FIVE),
                        new Card(Suit.DIAMOND, Value.SIX)
                ))));
    }

    @Test
    public void checksFalse() {
        Straight straight = new Straight();
        assertFalse(straight.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.DIAMOND, Value.ACE),
                        new Card(Suit.HEART, Value.TWO),
                        new Card(Suit.DIAMOND, Value.EIGHT)
                ))));
    }
}