package testdrivenmocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrajectPrijsServiceTest {

    TrajectPrijsService target;

    @BeforeEach
    public void setUp() {

        target = new TrajectPrijsService();

    }

    @Test
    public void testTrajectPrijs() throws InvalidLocationException {

        TrajectNaarTrajectEenhedenService eenhedenServiceMock = mock(TrajectNaarTrajectEenhedenService.class);
        when(eenhedenServiceMock.getTrajectEenheden(anyString(), anyString())).thenReturn(5);

        TrajectEenhedenNaarPrijsService prijsServiceMock = mock(TrajectEenhedenNaarPrijsService.class);
        when(prijsServiceMock.getPrijsTrajectEenheden(anyInt())).thenReturn(12);

        target.setEenhedenservice(eenhedenServiceMock);
        target.setPrijsservice(prijsServiceMock);

        int prijs = target.getTrajectprijs("Arnhem", "Utrecht");
        assertThat(prijs, is(12));

    }

    @Test
    void testInvalidLocationException() throws InvalidLocationException {

        TrajectNaarTrajectEenhedenService eenhedenServiceMock = mock(TrajectNaarTrajectEenhedenService.class);
        when(eenhedenServiceMock.getTrajectEenheden(anyString(), anyString())).thenReturn(5);

        TrajectEenhedenNaarPrijsService prijsServiceMock = mock(TrajectEenhedenNaarPrijsService.class);
        when(prijsServiceMock.getPrijsTrajectEenheden(anyInt())).thenReturn(12);

        target.setEenhedenservice(eenhedenServiceMock);
        target.setPrijsservice(prijsServiceMock);

//        f(x) = x^2;
//        f: x -> x^2
//        f(2)= 4
//        Function<Integer, Integer> f = x -> x * x;

        assertThrows(InvalidLocationException.class, () -> target.getTrajectprijs("Bogus", "Utrecht"));
    }
}