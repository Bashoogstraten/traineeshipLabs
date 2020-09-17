package H7;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class StartTest {

    @Test
    public void testPerson() throws PersonDiedException {
        Person jan = new Person("Jan", 45);
        Assert.assertEquals(Gender.UNKNOWN, jan.getGender());

        jan.setGender(Gender.MALE);
        Assert.assertEquals(Gender.MALE, jan.getGender());

        jan.haveBirthday();
        Assert.assertEquals(46, jan.getAge());

        Assert.assertEquals(3, Person.numberOfPossibleGenders);

    }

    @Test
    public void testException() throws PersonDiedException {
        Person jan = new Person("Jan", 130);
        Assert.assertThrows(PersonDiedException.class, jan::haveBirthday);

    }
}