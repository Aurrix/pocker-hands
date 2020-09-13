package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindTest {
    @Test
    public void checksTrue() {
        FourOfAKind fourOfAKind = new FourOfAKind();
        assertTrue(fourOfAKind.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Diamond, Value.Two),
                        new Card(Suit.Heart, Value.Two),
                        new Card(Suit.Diamond, Value.Eight)
                ))));
    }

    @Test
    public void checksFalse() {
        FourOfAKind fourOfAKind = new FourOfAKind();
        assertFalse(fourOfAKind.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Diamond, Value.Two),
                        new Card(Suit.Heart, Value.Ace),
                        new Card(Suit.Diamond, Value.Five)
                ))));
    }
}