package nextstep.blackjac.card;

public class HeartCard extends Card.Deck {
    public HeartCard(String cardShape) {
        super(cardShape);
    }

    @Override
    void addJoker() {
        cardList.add(new Card("Joker", cardShape, 10));
    }
}
