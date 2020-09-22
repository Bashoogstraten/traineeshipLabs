package H7.homework7;

public class Application {
    public static void main(String[] args) {

        try {
            Bank sns = new Bank();

            BankAccount jan = new BankAccount(0, 4000, 1.05, new Person("Janssen"));
            sns.addAccount(jan);
            BankAccount kees = new BankAccount(1, 30, 1.03, new Person("van der Geest") );
            sns.addAccount(kees);
            BankAccount sophie = new BankAccount(2, 200_000, 0.98, new Person("Hoogstraten"));
            sns.addAccount(sophie);
            BankAccount miep = new BankAccount(3, 80_000, 1.05, new Person("Achternaam"));
            sns.addAccount(miep);
            BankAccount henk = new BankAccount(4, 21_000, 1.05, new Person("Rutte"));
            sns.addAccount(henk);
            BankAccount klaas = new BankAccount(5, 1_500_000, 0.98, new Person("Kuyt"));
            sns.addAccount(klaas);
            BankAccount suzanne = new BankAccount(6, 360, 1.05, new Person("Dumoulin"));
            sns.addAccount(suzanne);
            BankAccount lisa = new BankAccount(7, 7500, 1.03, new Person("Pogacar"));
            sns.addAccount(lisa);
            BankAccount michel = new BankAccount(8, 55, 1.05, new Person("Roglic"));
            sns.addAccount(michel);
            BankAccount bas = new BankAccount(9, 25_000, 1.02, new Person("van Aert"));
            sns.addAccount(bas);
            BankAccount joey = new BankAccount(10);
            sns.addAccount(joey);

            sns.printAccounts();

            System.out.println();

            //            sns.addAccount(0, 4000, 1.05);

            System.out.println("Jan's initial balance: " + jan.getBalance());
            jan.withdrawBalance(300);
            System.out.println("Jan's balance after withdrawal: " + jan.getBalance());
            jan.depositBalance(500);
            System.out.println("Jan's balance after deposit: " + jan.getBalance());
            jan.addInterest();
            System.out.println("Jan's balance after interest: " + jan.getBalance());

            System.out.println("Sophie's initial balance: " + sophie.getBalance());
            sophie.addInterest();
            System.out.println("Sophie's balance after interest: " + sophie.getBalance());

            sns.transfer(1, 2, 100);
            System.out.println(sophie.getBalance());
            System.out.println(kees.getBalance());

            System.out.println("The total amount of money in the bank is " + sns.calculateTotal());

        } catch (BalanceTooLowException e) {
            System.out.println("This bank account's balance is too low to make this withdrawal.");
        } catch (TooManyBankAccountsException e) {
            System.out.println("There are no slots available for new bank accounts to be added.");
        }

    }

}
