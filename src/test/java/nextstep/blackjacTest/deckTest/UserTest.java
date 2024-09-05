package nextstep.blackjacTest.deckTest;

import nextstep.blackjac.domain.CloverCard;
import nextstep.blackjac.domain.Users;
import nextstep.blackjac.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {

    @DisplayName("유저 생성하기")
    @Test
    void createUser() {
        final String userNames = "pobi,jason";
        final int money = 10000;

        // Users users = new Users(userNames, money);
    }

    @DisplayName("유저 돈 chip으로 교환하는 기능 테스트")
    @Test
    void moenyToChip() {
        final String userNames = "pobi,jason";
        final int money = 10000;

        int wantChip = 1;
        new Users(userNames, money, wantChip);

        wantChip = 0;
        new Users(userNames, money, wantChip);

        assertThatThrownBy(() -> {
            new Users(userNames, money, 2);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("가진 돈 보다 원하는 chip의 갯수가 많습니다.");
    }

    @DisplayName("유저 이름 중 공백 및 null 허용 금지 기능 테스트")
    @Test
    void userName() {





        assertThatThrownBy(() -> {
            new Users(null, null);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("잘 못된 값입니다.");


    }



}
