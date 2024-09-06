package nextstep.blackjac.user;

import nextstep.blackjac.domain.Condition;
import nextstep.blackjac.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private List<User> users;
    private static final int CHIP_PRICE = 10000;

    public Users(String userNames, List<Integer> money) {
        List<String> splitName = Utils.splitName(userNames);
        checkUserCount(splitName);
        checkMoney(money, (hasMoney) -> hasMoney <= 0);
        Map<String, Integer> result = groupUserNameMoney(splitName, money);
        createUser(result);
    }

    private void createUser(Map<String, Integer> userAndMoney) {
        users = userAndMoney.entrySet()
                .stream()
                .map(entry -> new User(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        users.add(new Dealer());
    }

    private void checkMoney(List<Integer> money, Condition condition) {
        long count = money.stream()
                .filter(condition::condition)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("배팅 금액이 잘 못 되었습니다.");
        }
    }

    private void checkUserCount(List<String> users) {
        long userCount = users.size();
        if (userCount < 2 || userCount > 8) {
            throw new IllegalArgumentException("인원 수가 너무 적거나 많습니다.");
        }
    }

    private Map<String, Integer> groupUserNameMoney(List<String> splitName, List<Integer> money) {
        return IntStream.range(0, Math.min(splitName.size(), money.size()))
                .boxed()
                .collect(Collectors.toMap(splitName::get, money::get));
    }

    private int givenChip(int money, int wantChip) {
        return IntStream.rangeClosed(0, wantChip)
                .boxed()
                .reduce(0, (a, b) -> money - (b * money));
    }

    public List<User> getUsers() {
        return users;
    }
}
