package nextstep.blackjacTest.deckTest;

import nextstep.blackjac.user.Dealer;
import nextstep.blackjac.user.User;
import nextstep.blackjac.user.UserRole;
import nextstep.blackjac.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserTest {

    private final String names = "pobi,jason";
    private List<Integer> money;

    @DisplayName("유저 돈이 없거나 음수일때 기능 테스트")
    @Test
    void noHasMoney() {
        final int pobiMoney = 0;
        final int pobiJason = 10000;

        assertThatThrownBy(() -> {
            money = Arrays.asList(pobiMoney, pobiJason);
            new Users(names, money);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("배팅 금액이 잘 못 되었습니다.");
    }


    @DisplayName("유저 이름이 null일 경우 기능 테스트")
    @Test
    void userNameIsNull() {
        final int pobiMoney = 10000;
        final int pobiJason = 10000;
        money = Arrays.asList(pobiMoney, pobiJason);

        assertThatThrownBy(() -> {
            new Users(null, money);
        }).isInstanceOf(NullPointerException.class)
        .hasMessageContaining("이름이 정의되지않았습니다.");
    }

    @DisplayName("유저 이름이 공백일 경우 기능 테스트")
    @Test
    void userNameIsEmpty() {
        final int pobiMoney = 10000;
        final int pobiJason = 10000;
        money = Arrays.asList(pobiMoney, pobiJason);

        assertThatThrownBy(() -> {
            new Users("", money);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("인원 수가 너무 적거나 많습니다.");
    }

    @DisplayName("유저 생성 테스트")
    @Test
    void createUserTest() {
        final int pobiMoney = 10000;
        final int pobiJason = 10000;
        money = Arrays.asList(pobiMoney, pobiJason);

        Users users = new Users(names, money);
        List<User> userList = users.getUsers();
        assertThat(userList).isEqualTo(Arrays.asList(new User("pobi", 10000), new User("jason", 10000)));
    }

    @DisplayName("딜러 생성 테스트")
    @Test
    void createDealer() {
        Dealer dealer = new Dealer();
        assertThat(dealer).isEqualTo(new Dealer());
    }


}
