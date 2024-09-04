package nextstep.blackjac.domain;

import java.util.Arrays;

public class Users {
    private static final String REGEX = ",";

    public Users(String userNames) {
        Arrays.stream(userNames.split(REGEX))
                .map(User::new);





    }
}
