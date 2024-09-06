package nextstep.blackjacTest.deckTest;

import nextstep.blackjac.card.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CardTest {
    private Card.Deck deck;
    private List<Card> cardList = new ArrayList<>();

    @DisplayName("스페이드 카드 초기화 기능 테스트")
    @Test
    void spadeCardInit() {
        final String cardShape = "spade";
        deck = new SpadeCard(cardShape);
        initCardList(cardShape);
        cardList.add(new Card("Joker", cardShape, 10));

        assertThat(deck.getCardList()).isEqualTo(cardList);
    }

    @DisplayName("클로버 카드 초기화 기능 테스트")
    @Test
    void cloverCardInit() {
        final String cardShape = "clover";
        deck = new CloverCard(cardShape);
        initCardList(cardShape);

        assertThat(deck.getCardList()).isEqualTo(cardList);

        assertThatThrownBy(() -> {
            deck = new CloverCard(null);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("카드 모양이 잘 못 되었습니다.");
    }

    @DisplayName("하트 카드 초기화 기능 테스트")
    @Test
    void heartCardInit() {
        final String cardShape = "heart";
        deck = new HeartCard(cardShape);
        initCardList(cardShape);
        cardList.add(new Card("Joker", cardShape, 10));

        assertThat(deck.getCardList()).isEqualTo(cardList);

        assertThatThrownBy(() -> {
            deck = new HeartCard(null);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("카드 모양이 잘 못 되었습니다.");
    }

    @DisplayName("다이아몬드 카드 초기화 기능 테스트")
    @Test
    void diamondCardInit() {
        final String cardShape = "diamond";
        deck = new DiamondCard(cardShape);
        initCardList(cardShape);

        assertThat(deck.getCardList()).isEqualTo(cardList);

        assertThatThrownBy(() -> {
            deck = new DiamondCard(null);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("카드 모양이 잘 못 되었습니다.");
    }

    @DisplayName("카드 셔플 기능 테스트")
    @Test
    void shuffle() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.shuffle();
        assertThat(cards.size()).isEqualTo(54);
        System.out.println(cards);
    }

    private void initCardList(String cardShape) {
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

}
