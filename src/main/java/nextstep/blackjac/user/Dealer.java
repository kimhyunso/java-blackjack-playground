package nextstep.blackjac.user;

public class Dealer extends User {
    private static final String name = "Dealer";

    public Dealer() {
        super(name, UserRole.DEALER);
    }

}
