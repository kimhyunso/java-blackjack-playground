package nextstep.blackjacTest.deckTest;

import nextstep.blackjac.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    @DisplayName("유저 생성하기")
    @Test
    void spadeCardInit() {
        final String userNames = "pobi,jason";

        Users users = new Users(userNames);



    }



}
