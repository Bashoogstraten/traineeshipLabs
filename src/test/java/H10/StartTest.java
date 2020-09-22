package H10;

import org.junit.Assert;
import org.junit.Test;

public class StartTest {

    @Test
    public void testCreditBalanceAfterPayMethod() throws ArgumentOutOfRangeException {
        RegularCard jantje = new RegularCard(0, "Jantje", 5000);
        GoldCard bas = new GoldCard(1, "Bas", 5000);
        bas.setDiscount(20);

        jantje.pay(500);
        Assert.assertEquals(4500, jantje.getCreditBalance(), 1e-8);
        bas.pay(500);
        Assert.assertEquals(4600, bas.getCreditBalance(), 1e-8);

    }
}