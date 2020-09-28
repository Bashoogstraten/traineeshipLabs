package H7.homework7;

public class BankAccount {

    private int number;
    private double balance;
    private double interestRate;
    private Person person;
    //private double interestAmount = (balance * interestRate);

    public static final int MIN_BALANCE = 0;

    public BankAccount() {
        this(0, 0, 1.05, new Person());
    }

    public BankAccount(int number) {
        this(number, 0, 1.05, new Person());
    }

    public BankAccount(int number, double balance) {
        this(number, balance, 1.05, new Person());

    }

    public BankAccount(int number, double balance, double interestRate) {
        this(number, balance, interestRate, new Person());
    }

    public BankAccount(int number, double balance, double interestRate, Person person) {
        this.number = number;
        this.balance = balance;
        this.interestRate = interestRate;
        this.person = person;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getNumber() {
        return this.number;
    }

    public double withdrawBalance(double withdrawAmount) throws BalanceTooLowException {

        if (this.balance - withdrawAmount >= MIN_BALANCE) {
            this.balance -= withdrawAmount;
            return this.balance;
        } else {
            throw new BalanceTooLowException();
        }
    }

    public double depositBalance(double depositAmount) {
        this.balance += depositAmount;
        return this.balance;
    }

    public double addInterest() {
        this.balance *= this.interestRate;
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account " + this.number + " has balance " + this.balance;
    }
}
