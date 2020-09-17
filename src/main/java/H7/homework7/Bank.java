package H7.homework7;

public class Bank {

    private BankAccount[] accounts = new BankAccount[10];
    private int index = 0;

    public void addAccount(BankAccount account) {
        if (index < accounts.length) {
            accounts[index] = account;
            index++;
        }
    }

    public void transfer(int from, int to, double amount) {
        for (BankAccount account : this.accounts) {
            if (account.getNumber() == from) {
                try {
                    account.withdrawBalance(amount);
                } catch (BalanceTooLowException e) {
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
