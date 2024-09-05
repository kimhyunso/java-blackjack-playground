package nextstep.blackjac.domain;

import nextstep.blackjac.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private List<User> users;
    private static final int CHIP_PRICE = 10000;

    public Users(String userNames, int money, int wantChip) {
        int giveChip = givenChip(money, wantChip);
        if (giveChip < 0) {
            throw new IllegalArgumentException("가진 돈 보다 원하는 chip의 갯수가 많습니다.");
        }

    }

    public Users(String userNames, int money) {
        Utils.splitName(userNames)
                .stream()
                .map(String::length)
                .filter(item -> item < 0)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("구성 인원이 맞지 않습니다."));
    }

    private int givenChip(int money, int wantChip) {
        return IntStream.rangeClosed(0, wantChip)
                .boxed()
                .reduce(0, (a, b) -> money - (b * money));
    }


}
