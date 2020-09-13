package net.projecteuler.aurrix.pockerhands.hands.ranks.impl;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseTest {
    @Test
    public void checksTrue() {
        FullHouse fullHouse = new FullHouse();
        assertTrue(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Ace),
                        new Card(Suit.Diamond, Value.Ace)
                ))));
    }

    @Test
    public void checksReverse() {
        FullHouse fullHouse = new FullHouse();
        assertTrue(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Club, Value.Ace),
                        new Card(Suit.Diamond, Value.Ace),
                        new Card(Suit.Heart, Value.Two),
                        new Card(Suit.Diamond, Value.Two)
                ))));
    }

    @Test
    public void checksFalse() {
        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Three),
                        new Card(Suit.Club, Value.Two),
                        new Card(Suit.Diamond, Value.Two),
                        new Card(Suit.Heart, Value.Two),
                        new Card(Suit.Diamond, Value.Four)
                ))));
    }
    @Test
    public void checksFalse2() {
        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.Club, Value.Three),
                        new Card(Suit.Club, Value.Three),
                        new Card(Suit.Diamond, Value.Six),
                        new Card(Suit.Heart, Value.Queen),
                        new Card(Suit.Diamond, Value.Queen)
                ))));
    }
}