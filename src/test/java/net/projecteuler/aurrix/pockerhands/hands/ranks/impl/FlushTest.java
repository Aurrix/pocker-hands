package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlushTest {
    @Test
    public void checksTrue() {
        Flush flush = new Flush();
        assertTrue(flush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.CLUB, Value.EIGHT),
                        new Card(Suit.CLUB, Value.EIGHT)
                ))));
    }

    @Test
    public void checksFalse() {
        Flush flush = new Flush();
        assertFalse(flush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.DIAMOND, Value.ACE),
                        new Card(Suit.HEART, Value.TWO),
                        new Card(Suit.DIAMOND, Value.EIGHT)
                ))));
    }
}