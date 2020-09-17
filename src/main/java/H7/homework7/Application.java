package H7.homework7;

public class Application {
    public static void main(String[] args) {

        try {
            Bank sns = new Bank();

            BankAccount jan = new BankAccount(0, 4000, 1.05);
            sns.addAccount(jan);
            BankAccount kees = new BankAccount(1, 30, 1.03);
            sns.addAccount(kees);
            BankAccount sophie = new BankAccount(2, 200_000, 0.98);
            sns.addAccount(sophie);

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

            sns.transfer(2, 1, 100);
            System.out.println(sophie.getBalance());
            System.out.println(kees.getBalance());

        } catch (BalanceTooLowException e) {
            System.out.println("This bank account's balance is too low to make this withdrawal.");
        }

    }

}
