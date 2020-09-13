package net.projecteuler.aurrix.pockerhands.hands.cards.value;

public enum Value {

    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("T", 10),
    Jack("J", 11),
    Queen("Q", 12),
    King("K", 13),
    Ace("A", 14);


    public int value;
    public String character;

    private Value(String character, int value) {
        this.character = character;
        this.value = value;
    }
}
