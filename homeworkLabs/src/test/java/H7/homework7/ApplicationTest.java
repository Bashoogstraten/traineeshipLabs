package H7.homework7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void testBankAccount() throws BalanceTooLowException, TooManyBankAccountsException {
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

        jan.withdrawBalance(300);
        Assert.assertEquals(3700, jan.getBalance(), 1e-8);
        jan.depositBalance(500);
        Assert.assertEquals(4200, jan.getBalance(), 1e-8);
        jan.addInterest();
        Assert.assertEquals(4410, jan.getBalance(), 1e-8);

    }
}