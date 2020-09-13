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
                        new Card(Suit.Club, Value.Ten),
                        new Card(Suit.Club, Value.Jack),
                        new Card(Suit.Club, Value.Queen),
                        new Card(Suit.Club, Value.King),
                        new Card(Suit.Club, Value.Ace)
                ))));
    }

    @Test
    public void checksFalse() {
        RoyalFlush royalFlush = new RoyalFlush(new Flush());
        assertFalse(royalFlush.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Nine),
                        new Card(Suit.Club, Value.Ten),
                        new Card(Suit.Club, Value.Jack),
                        new Card(Suit.Club, Value.Queen),
                        new Card(Suit.Club, Value.King)
                ))));
    }
}