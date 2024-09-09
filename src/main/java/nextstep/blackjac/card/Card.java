package nextstep.blackjac.card;

import java.util.*;

public class Card {
    private String cardName;
    private String cardShape;
    private int cardNumber;

    public Card(String cardName, String cardShape, int cardNumber) {
        this.cardName = cardName;
        this.cardShape = cardShape;
        this.cardNumber = cardNumber;
    }

    public Card(String cardName, String cardShape) {
        this.cardName = cardName;
        this.cardShape = cardShape;
    }

    public Card(String cardShape, int cardNumber) {
        this.cardShape = cardShape;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber == card.cardNumber && Objects.equals(cardName, card.cardName) && Objects.equals(cardShape, card.cardShape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardName, cardShape, cardNumber);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardPosition='" + cardName + '\'' +
                ", cardShape='" + cardShape + '\'' +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
