package nextstep.blackjac;

import nextstep.blackjac.controller.UserController;
import nextstep.blackjac.view.BlackJacView;

public class Main {
    private static UserController userController = new UserController();

    public static void main(String[] args) {
        userController.play();
    }

}
