package H10;

public class GoldCard extends Card {

    private int discount;

    public static final int MAX_DISCOUNT = 30;

    public GoldCard() {
        super(0, "Name unknown", 0);

    }

    public GoldCard(int cardID) {
        super(cardID, "Name unknown", 0);
    }

    public GoldCard(int cardID, String firstName) {
        super(cardID, firstName, 0);

    }

    public GoldCard(int cardID, String firstName, double creditBalance) {
        super(cardID, firstName, creditBalance);
    }

    public GoldCard(int cardID, String firstName, double creditBalance, int discount) {
        super(cardID, firstName, creditBalance);
        this.discount = discount;
    }

    public void setDiscount(int percent) throws ArgumentOutOfRangeException {
        if(percent > 0 && percent <= MAX_DISCOUNT){
            this.discount = percent;
        } else {
            throw new ArgumentOutOfRangeException();
        }
    }

    @Override
    boolean pay(double amount){
        double discountAmount = (amount * (1 - (this.discount / 100.0)));
        if((super.creditBalance - discountAmount) >= MIN_BALANCE){
            super.creditBalance -= discountAmount;
            return true;
        } else {
            return false;
        }
    }

}
