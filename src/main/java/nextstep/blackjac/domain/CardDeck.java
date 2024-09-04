package nextstep.blackjac.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    private SpadeCard spadeCardDeck;
    private HeartCard heartCardDeck;
    private DiamondCard diamondCardDeck;
    private CloverCard cloverCardDeck;

    public CardDeck() {
        spadeCardDeck = new SpadeCard("spade");
        heartCardDeck = new HeartCard("heart");
        diamondCardDeck = new DiamondCard("diamond");
        cloverCardDeck = new CloverCard("clover");
    }

    public List<Card> shuffle() {
        List<Card> cardDeck = concat();
        Collections.shuffle(cardDeck);

        return cardDeck;
    }

    private List<Card> concat() {
        cardShuffle();
        List<Card> shuffleSpadeCardDeck = spadeCardDeck.getCardList();
        List<Card> shuffleHeartCardDeck = heartCardDeck.getCardList();
        List<Card> shuffleDiamondCardDeck = diamondCardDeck.getCardList();
        List<Card> shuffleCloverCardDeck = cloverCardDeck.getCardList();

        return Stream.of(shuffleSpadeCardDeck, shuffleHeartCardDeck, shuffleDiamondCardDeck, shuffleCloverCardDeck)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private void cardShuffle() {
        spadeCardDeck.shuffle();
        heartCardDeck.shuffle();
        diamondCardDeck.shuffle();
        cloverCardDeck.shuffle();
    }


}
