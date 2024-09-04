package nextstep.blackjac.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpadeCard extends Deck {
    public SpadeCard(String cardShape) {
        super(cardShape);
    }

    @Override
    void addJoker() {
        cardList.add(new Card("Joker", cardShape, 10));
    }

}
