package net.projecteuler.aurrix.pockerhands.hands.cards.suits;

public enum Suit {
    Diamond("D"),
    Club("C"),
    Heart("H"),
    Spade("S");

    public String letter;

    private Suit (String letter){
        this.letter = letter;
    }
}
