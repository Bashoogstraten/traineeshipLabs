package H10;

public class RegularCard extends Card {

    public RegularCard() {
        super(0, "Name unknown", 0);

    }

    public RegularCard(int cardID) {
        super(cardID, "Name unknown", 0);
    }

    public RegularCard(int cardID, String firstName) {
        super(cardID, firstName, 0);

    }

    public RegularCard(int cardID, String firstName, double creditBalance) {
        super(cardID, firstName, creditBalance);
    }


}
