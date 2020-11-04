package H11.extrabank;

public class Bank {

    public abstract class BankAccount {

        private int number;
        private double balance;
        private double interestRate;
        private Person person;

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



    private BankAccount[] accounts = new BankAccount[10];
    private int index = 0;

    public void addAccount(BankAccount account) throws TooManyBankAccountsException {
        if (index < accounts.length) {
            accounts[index] = account;
            index++;
        } else {
            throw new TooManyBankAccountsException();
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (BankAccount account : this.accounts) {
            total = total + account.getBalance();
        }
        return total;
    }

    public void printAccounts() {
        for (BankAccount account : this.accounts) {
            System.out.println(account);
        }
    }

    public void transfer(int from, int to, double amount) {
        for (BankAccount account : this.accounts) {
            if (account != null && account.getNumber() == from) {
                try {
                    account.withdrawBalance(amount);
                } catch (BalanceTooLowException e) {
                    System.out.println("The 'From' account's balance is too low to transfer this sum.");
                    return;
                }
            }
        }
        for (BankAccount account : this.accounts) {
            if (account.getNumber() == to) {
                account.depositBalance(amount);
            }
        }
    }
}

//    public void addAccount(int number, double balance, double interestRate) {
//        BankAccount account = new BankAccount(number, balance, interestRate);
//        if (index < accounts.length) {
//            accounts[index] = account;
//            index++;
//        }
//    }
