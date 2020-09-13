package net.projecteuler.aurrix.pockerhands.hands.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.projecteuler.aurrix.pockerhands.hands.cards.suits.Suit;
import net.projecteuler.aurrix.pockerhands.hands.cards.value.Value;

@AllArgsConstructor
@Setter
@Getter
public class Card implements Comparable<Card> {
    private Suit suit;
    private Value value;

    @Override
    public String toString() {
        return value.character + suit.letter;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card card = (Card) o;
            return card.getValue().value == this.getValue().value && card.suit.letter.equals(this.suit.letter);
        } else return false;
    }

    @Override
    public int hashCode() {
        return this.suit.letter.hashCode() + this.value.value;
    }

    @Override
    public int compareTo(Card card) {
        return this.value.value - card.value.value;
    }
}