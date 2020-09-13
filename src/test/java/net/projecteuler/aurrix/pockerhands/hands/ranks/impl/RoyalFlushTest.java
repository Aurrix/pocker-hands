package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoyalFlushTest {
    @Test
    public void checksTrue() {
        RoyalFlush royalFlush = new RoyalFlush(new Flush());
        assertTrue(royalFlush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.TEN),
                        new Card(Suit.CLUB, Value.JACK),
                        new Card(Suit.CLUB, Value.QUEEN),
                        new Card(Suit.CLUB, Value.KING),
                        new Card(Suit.CLUB, Value.ACE)
                ))));
    }

    @Test
    public void checksFalse() {
        RoyalFlush royalFlush = new RoyalFlush(new Flush());
        assertFalse(royalFlush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.NINE),
                        new Card(Suit.CLUB, Value.TEN),
                        new Card(Suit.CLUB, Value.JACK),
                        new Card(Suit.CLUB, Value.QUEEN),
                        new Card(Suit.CLUB, Value.KING)
                ))));
    }
}