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
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.DIAMOND, Value.ACE),
                        new Card(Suit.HEART, Value.ACE),
                        new Card(Suit.DIAMOND, Value.ACE)
                ))));
    }

    @Test
    public void checksReverse() {
        FullHouse fullHouse = new FullHouse();
        assertTrue(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.CLUB, Value.ACE),
                        new Card(Suit.DIAMOND, Value.ACE),
                        new Card(Suit.HEART, Value.TWO),
                        new Card(Suit.DIAMOND, Value.TWO)
                ))));
    }

    @Test
    public void checksFalse() {
        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.THREE),
                        new Card(Suit.CLUB, Value.TWO),
                        new Card(Suit.DIAMOND, Value.TWO),
                        new Card(Suit.HEART, Value.TWO),
                        new Card(Suit.DIAMOND, Value.FOUR)
                ))));
    }
    @Test
    public void checksFalse2() {
        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.checks(
                new Hand(Arrays.asList(
                        new Card(Suit.CLUB, Value.THREE),
                        new Card(Suit.CLUB, Value.THREE),
                        new Card(Suit.DIAMOND, Value.SIX),
                        new Card(Suit.HEART, Value.QUEEN),
                        new Card(Suit.DIAMOND, Value.QUEEN)
                ))));
    }
}