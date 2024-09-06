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

    public abstract static class Deck {
        protected List<Card> cardList;
        protected int cardCount = 13;
        protected String cardShape;

        protected Deck(String cardShape) {
            this.cardShape = Optional.ofNullable(cardShape)
                    .orElseThrow(() -> new IllegalArgumentException("카드 모양이 잘 못 되었습니다."));
            cardList = new ArrayList<>();
            init();
            addJoker();
        }

        void init() {
            cardList.add(new Card("A", cardShape, 1));
            cardList.add(new Card("2", cardShape, 2));
            cardList.add(new Card("3", cardShape, 3));
            cardList.add(new Card("4", cardShape, 4));
            cardList.add(new Card("5", cardShape, 5));
            cardList.add(new Card("6", cardShape, 6));
            cardList.add(new Card("7", cardShape, 7));
            cardList.add(new Card("8", cardShape, 8));
            cardList.add(new Card("9", cardShape, 9));
            cardList.add(new Card("10", cardShape, 10));
            cardList.add(new Card("Jack", cardShape, 10));
            cardList.add(new Card("Queen", cardShape, 10));
            cardList.add(new Card("King", cardShape, 10));
        }

        void shuffle() {
            Collections.shuffle(getCardList());
        }

        abstract void addJoker();

        public List<Card> getCardList() {
            return cardList;
        }

    }
}
