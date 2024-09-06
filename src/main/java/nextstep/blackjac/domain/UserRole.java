package nextstep.blackjac.domain;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public enum UserRole {
    USER, VIP;

    public static UserRole getRole(String userName) {
        try {
            String contents = new String(Files.readAllBytes(Paths
                    .get("src/main/resources/VIPLIST")), StandardCharsets.UTF_8);

            if (contents.contains(userName)) {
                return UserRole.VIP;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return UserRole.USER;
    }

}
