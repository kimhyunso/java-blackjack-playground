package nextstep.blackjac.user;

import nextstep.blackjac.card.Card;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {
    private String name;
    private int money;
    private Chip chip;
    private UserRole userRole;
    private List<Card> givenCardList = new ArrayList<>();

    public User() {}

    public User(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
    }

    public User(String name, int money) {
        this.name = Optional.ofNullable(name)
                .orElseThrow(() -> new NullPointerException("이름이 비어 있거나 Null입니다."));
        if (money <= 0) {
            throw new IllegalArgumentException("배팅 금액이 너무 작습니다.");
        }
        this.money = money;
        this.userRole = UserRole.getRole(name);
    }

    public User givenCardList(Card card) {
        givenCardList.add(card);
        return this;
    }

    public List<Card> getGivenCardList() {
        return givenCardList;
    }

    public int cardNumberTotal() {
        return givenCardList.stream()
                .map(item -> item.cardNumberTotal(item))
                .reduce(0, Integer::sum);
    }

    public int payment(User loseUser, int userCount) {
        return this.money += (loseUser.money / (userCount - 1));
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
        return name;
    }
}
