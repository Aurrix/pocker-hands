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
    public int compareTo(Card card) {
        return this.value.value - card.value.value;
    }
}
