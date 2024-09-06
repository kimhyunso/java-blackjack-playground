package nextstep.blackjac.user;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public enum UserRole {
    USER, VIP, DEALER;

    public static UserRole getRole(String userName) {
        String content = readVipFileList();
        if (content.contains(userName)) {
            return UserRole.VIP;
        }
        return UserRole.USER;
    }

    private static String readVipFileList() {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths
                    .get("src/main/resources/VIPLIST")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content;
    }

}
