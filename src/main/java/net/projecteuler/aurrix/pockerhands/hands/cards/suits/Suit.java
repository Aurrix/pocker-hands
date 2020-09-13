package net.projecteuler.aurrix.pockerhands.hands.cards.suits;

public enum Suit {
    DIAMOND("D"),
    CLUB("C"),
    HEART("H"),
    SPADE("S");

    public String letter;

    Suit (String letter){
        this.letter = letter;
    }
}
