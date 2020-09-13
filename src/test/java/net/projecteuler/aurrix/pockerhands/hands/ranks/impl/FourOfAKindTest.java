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
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.DIAMOND, Value.TWO),
                        new Card(Suit.HEART, Value.TWO),
                        new Card(Suit.DIAMOND, Value.EIGHT)
                ))));
    }

    @Test
    public void checksFalse() {
        FourOfAKind fourOfAKind = new FourOfAKind();
        assertFalse(fourOfAKind.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.DIAMOND, Value.TWO),
                        new Card(Suit.HEART, Value.ACE),
                        new Card(Suit.DIAMOND, Value.FIVE)
                ))));
    }
}