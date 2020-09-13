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
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.DIAMOND, Value.ACE),
                        new Card(Suit.HEART, Value.THREE),
                        new Card(Suit.DIAMOND, Value.EIGHT)
                ))));
    }

    @Test
    public void checksFalse() {
        OnePair onePair = new OnePair();
        assertFalse(onePair.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.QUEEN),
                        new Card(Suit.DIAMOND, Value.ACE),
                        new Card(Suit.HEART, Value.THREE),
                        new Card(Suit.DIAMOND, Value.EIGHT)
                ))));
    }

    @Test
    public void getHandScore() {
    }
}