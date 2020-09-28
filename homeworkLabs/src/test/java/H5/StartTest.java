package H5;

import org.junit.Assert;
import org.junit.Test;

public class StartTest {

    @Test
    public void testGreatest() {
        Lab target = new Lab();
        int antwoordxyz = target.greatest(8, 9);
        System.out.println(antwoordxyz);
        Assert.assertEquals(9, antwoordxyz);
    }

    @Test
    public void testTheSecondGreatest() {
        Lab target = new Lab();
        String antwoordLangste = target.greatest("Long", "Longer");
        System.out.println(antwoordLangste);
        Assert.assertEquals("Longer", antwoordLangste);
    }

    @Test
    public void testTheThirdGreatest() {
        Lab target = new Lab();
        int antwoordGrootste = target.greatest(1,2,300,4);
        System.out.println(antwoordGrootste);
        Assert.assertEquals(300, antwoordGrootste);
    }

    @Test
    public void testFactorial() {
        Lab target = new Lab();
        int antwoordFactorial = target.factorial(5);
        System.out.println(antwoordFactorial);
        Assert.assertEquals(120, antwoordFactorial);
    }
}
