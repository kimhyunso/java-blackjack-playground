package nextstep.blackjac.controller;

import nextstep.blackjac.card.Card;
import nextstep.blackjac.card.CardDeck;
import nextstep.blackjac.user.User;
import nextstep.blackjac.user.Users;
import nextstep.blackjac.utils.Utils;
import nextstep.blackjac.view.BlackJacView;

import java.util.List;
import java.util.Stack;

public class UserController {

    private BlackJacView blackJacView = new BlackJacView();
    private CardDeck cardDeck = new CardDeck();
    private Users users;
    private Stack<Card> shuffleCardDeck;


    public void play() {
        while (true) {
            String names = blackJacView.joinPeople();
            List<String> userNames = Utils.splitName(names);
            List<Integer> money = blackJacView.batting(userNames);
            users = new Users(userNames, money);
            List<User> userList = users.getUsers();

            cardDeck.shuffle();
            shuffleCardDeck = cardDeck.getCardDeck();

            users.givenCards(shuffleCardDeck);
            blackJacView.givenCard(names, userList);

            User user = blackJacView.givenMoreCard(userList, shuffleCardDeck);
            blackJacView.getUserCardList(user);

            if (blackJacView.endGame()) {
                break;
            }
        }
    }



}
