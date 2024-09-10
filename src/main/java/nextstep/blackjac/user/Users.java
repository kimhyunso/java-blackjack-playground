package nextstep.blackjac.user;

import nextstep.blackjac.card.Card;
import nextstep.blackjac.domain.Condition;
import nextstep.blackjac.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private List<User> users;
    private static final int CHIP_PRICE = 10000;

    public Users(List<String> names, List<Integer> money) {
        checkUserCount(names);
        Map<String, Integer> result = groupUserNameMoney(names, money);
        createUser(result);
    }

    public List<User> getUsers() {
        return users;
    }

    public void givenCards(Stack<Card> cardDeck) {
        for (User user : users) {
            user.givenCardList(cardDeck.pop());
            user.givenCardList(cardDeck.pop());
        }
    }

    private void createUser(Map<String, Integer> userAndMoney) {
        users = userAndMoney.entrySet()
                .stream()
                .map(entry -> new User(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        users.add(new Dealer());
    }

    private void checkUserCount(List<String> users) {
        long userCount = users.size();
        if (userCount < 2 || userCount > 8) {
            throw new IllegalArgumentException("인원 수가 너무 적거나 많습니다.");
        }
    }

    private Map<String, Integer> groupUserNameMoney(List<String> userName, List<Integer> money) {
        return IntStream.range(0, Math.min(userName.size(), money.size()))
                .boxed()
                .collect(Collectors.toMap(userName::get, money::get));
    }

    private int givenChip(int money, int wantChip) {
        return IntStream.rangeClosed(0, wantChip)
                .boxed()
                .reduce(0, (a, b) -> money - (b * money));
    }
}
