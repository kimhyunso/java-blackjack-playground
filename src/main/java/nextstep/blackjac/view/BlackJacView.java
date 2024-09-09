package nextstep.blackjac.view;

import nextstep.blackjac.Main;
import nextstep.blackjac.card.Card;
import nextstep.blackjac.card.CardDeck;
import nextstep.blackjac.user.Dealer;
import nextstep.blackjac.user.User;
import nextstep.blackjac.user.Users;
import nextstep.blackjac.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BlackJacView {
    private Scanner input = new Scanner(System.in);

    public String joinPeople() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String userNames = input.nextLine();
        return userNames;
    }

    public List<Integer> batting(List<String> userNames) {
        List<Integer> money = new ArrayList<>();
        for (String name : userNames) {
            System.out.println(name + "의 배팅 금액은?");
            money.add(input.nextInt());
        }

        return money;
    }

    public void givenCard(String userNames, List<User> users) {
        System.out.println("딜러," + userNames + "에게 각각 2장의 카드를 나누어 주었습니다.");
        for (User user : users) {
            getUserCardList(user);
        }
    }

    public User givenMoreCard(List<User> users) {
        for (User user : users) {
            System.out.println(user + "는 한장의 카드를 더 받겠습니까?");
            String moreCard = input.nextLine();
            if (moreCard.equalsIgnoreCase("y")) {
                return user;
            }
        }
        return null;
    }

    public void getUserCardList(User user) {
        List<Card> cards = user.getGivenCardList();
        System.out.println(user + ": " + cards);
    }

    public boolean endGame() {
        System.out.println("게임을 종료하시겠습니까? (y,n)");
        String endGame = input.next();
        return endGame.equalsIgnoreCase("y");
    }

}
