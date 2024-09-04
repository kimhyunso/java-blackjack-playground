package nextstep.blackjac.domain;

public class HeartCard extends Deck {
    public HeartCard(String cardShape) {
        super(cardShape);
    }

    @Override
    void addJoker() {
        cardList.add(new Card("Joker", cardShape, 10));
    }
}
