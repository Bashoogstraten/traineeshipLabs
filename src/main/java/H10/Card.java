package H10;

public class Card {

    private int cardID;
    private String firstName;
    protected double creditBalance;

    public static final int MIN_BALANCE = 0;

    public Card() {
        this(0, "Name unknown", 0);

    }

    public Card(int cardID) {
        this(cardID, "Name unknown", 0);
    }

    public Card(int cardID, String firstName) {
        this(cardID, firstName, 0);

    }

    public Card(int cardID, String firstName, double creditBalance) {
        this.cardID = cardID;
        this.firstName = firstName;
        this.creditBalance = creditBalance;
    }

    public double getCreditBalance(){

        return this.creditBalance;
    }

    boolean pay(double amount){
        if((this.creditBalance - amount) >= MIN_BALANCE){
            this.creditBalance -= amount;
            return true;
        } else {
            return false;
        }
    }

}
