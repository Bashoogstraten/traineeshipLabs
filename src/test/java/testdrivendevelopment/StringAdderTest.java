package testdrivendevelopment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringAdderTest {

    @Test
    public void whenAddIsCalledWithEmptyStringItShouldReturnZero() {
        StringAdder adder = new StringAdder();
        int result = adder.add("");
        assertEquals(0, result);
    }

    @Test
    public void whenAddIsCalledWithOneItShouldReturnOne() {
        StringAdder adder = new StringAdder();
        int result = adder.add("1");
        assertEquals(1, result);
    }

    @Test
    public void whenAddIsCalledWithTwoNumbersInAStringItShouldReturnTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add("1,2");
        assertEquals(3, result);
    }

    @Test
    public void whenAddIsCalledWithTwoDifferentNumbersInAStringItShouldReturnTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add("1,5");
        assertEquals(6, result);
    }

    @Test
    void whenAddIsCalledWithANewLineSeparatingTheTwoNumbersItShouldReturnTheSum() {
        StringAdder adder = new StringAdder();
        int result = adder.add("1\n5,7");
        assertEquals(6, result);
    }
}