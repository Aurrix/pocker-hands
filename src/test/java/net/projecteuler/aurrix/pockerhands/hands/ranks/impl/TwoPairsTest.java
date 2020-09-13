package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairsTest {
    @Test
    public void checksTrue() {
        TwoPairs twoPairs = new TwoPairs();
        assertTrue(twoPairs.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Eight),
                        new Card(Suit.Diamond, Value.Eight)
                ))));
    }

    @Test
    public void checksFalse() {
        TwoPairs twoPairs = new TwoPairs();
        assertFalse(twoPairs.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Two),
                        new Card(Suit.Diamond, Value.Eight)
                ))));
    }

}