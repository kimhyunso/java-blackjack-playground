package nextstep.blackjac.card;

public class SpadeCard extends Deck {
    public SpadeCard(String cardShape) {
        super(cardShape);
    }

    @Override
    void addJoker() {
        cardList.add(new Card("Joker", cardShape, 10));
    }

}
