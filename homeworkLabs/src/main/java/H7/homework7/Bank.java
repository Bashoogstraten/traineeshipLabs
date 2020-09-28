package H7.homework7;

public class Bank {

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
