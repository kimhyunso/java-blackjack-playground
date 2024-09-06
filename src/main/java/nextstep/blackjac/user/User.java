package nextstep.blackjac.user;

import java.util.Objects;

public class User {
    private String name;
    private int money;
    private Chip chip;
    private UserRole userRole;

    public User() {}

    public User(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
        this.userRole = UserRole.getRole(name);
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return money == user.money && Objects.equals(name, user.name) && Objects.equals(chip, user.chip) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, chip, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", chip=" + chip +
                ", userRole=" + userRole +
                '}';
    }
}
