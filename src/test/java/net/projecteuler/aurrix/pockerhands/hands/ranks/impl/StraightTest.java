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
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Three),
                        new Card(Suit.Diamond, Value.Four),
                        new Card(Suit.Heart, Value.Five),
                        new Card(Suit.Diamond, Value.Six)
                ))));
    }

    @Test
    public void checksFalse() {
        Straight straight = new Straight();
        assertFalse(straight.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Two),
                        new Card(Suit.Diamond, Value.Eight)
                ))));
    }
}