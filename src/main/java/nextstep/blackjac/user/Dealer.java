package nextstep.blackjac.user;

public class Dealer extends User {
    private static final String name = "Dealer";
    public static final int AUTO_GIVEN_CARD = 16;

    public Dealer() {
        super(name, UserRole.DEALER);
    }

}
