package nextstep.blackjac.domain;

import java.io.IOException;
import java.util.Objects;

public class User {
    private String name;
    private int money;
    private int hasChip = 1;
    private UserRole userRole;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public User(String name, int money, int hasChip) throws IOException {
        this.name = name;
        this.money = money;
        this.hasChip = hasChip;
        this.userRole = UserRole.getRole(name);
    }

    public User name(String name) {
        this.name = name;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return money == user.money && hasChip == user.hasChip && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, hasChip);
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", hasChip=" + hasChip +
                '}';
    }
}
