package nextstep.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @Test
    public void getUser() {
        Users users = new Users();
        assertThat(users.getUser("crong")).isEqualTo(new User("crong", 35));
    }


    @Test
    public void getDefaultUser() {
        Users users = new Users();
        assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
    }

    @DisplayName("getUser 스트림 테스트")
    @Test
    void getUserToStream() {
        Users users = new Users();
        assertThat(users.getUserToStream("crong")).isEqualTo(new User("crong", 35));
    }

    @DisplayName("getDefaultUser 스트림 테스트")
    @Test
    void getDefaultUserToStream() {
        Users users = new Users();
        assertThat(users.getUserToStream("codesquard")).isEqualTo(Users.DEFAULT_USER);
    }
}
