package nextstep.blackjac.card;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    private SpadeCard spadeCardDeck;
    private HeartCard heartCardDeck;
    private DiamondCard diamondCardDeck;
    private CloverCard cloverCardDeck;
    private Stack<Card> cardDeck;

    public CardDeck() {
        spadeCardDeck = new SpadeCard("spade");
        heartCardDeck = new HeartCard("heart");
        diamondCardDeck = new DiamondCard("diamond");
        cloverCardDeck = new CloverCard("clover");
    }

    public void shuffle() {
        List<Card> cardDeck = concat();
        Collections.shuffle(cardDeck);
        cardDeck = createDeck(cardDeck);
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

    private Stack<Card> createDeck(List<Card> shuffleCard) {
        cardDeck = new Stack<Card>();
        cardDeck.addAll(shuffleCard);
        return cardDeck;
    }

    public Stack<Card> getCardDeck() {
        return cardDeck;
    }
}
