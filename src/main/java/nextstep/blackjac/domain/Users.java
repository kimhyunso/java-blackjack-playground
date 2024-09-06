package nextstep.blackjac.domain;

import nextstep.blackjac.utils.Utils;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Users {
    private List<User> users;
    private static final int CHIP_PRICE = 10000;

    public Users(String userNames, List<Integer> money) throws IOException {
        List<String> splitName = Utils.splitName(userNames);
        checkUserCount(splitName);
        checkMoney(money, (x) -> x <= 0);

        Map<String, Integer> result = IntStream.range(0, Math.min(splitName.size(), money.size()))
                .boxed()
                .collect(Collectors.toMap(splitName::get, money::get));

        createUser(result);
    }

    private void createUser(Map<String, Integer> userAndMoney) throws IOException {
        users = userAndMoney.entrySet()
                .stream()
                .map(entry -> new User(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
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

    private int givenChip(int money, int wantChip) {
        return IntStream.rangeClosed(0, wantChip)
                .boxed()
                .reduce(0, (a, b) -> money - (b * money));
    }
}
