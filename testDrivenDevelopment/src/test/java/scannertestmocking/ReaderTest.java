package scannertestmocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReaderTest {

    @BeforeEach
    void setUp() {
        Reader target = new Reader();
    }

    @Test
    void testScannerMocking() {

        Reader target = new Reader();
        ScannerWrapper mockedScanner = mock(ScannerWrapper.class);
        target.setScannerWrapper(mockedScanner);
        when(mockedScanner.read()).thenReturn("Mocking successful");

        String test = target.readString();
        assertThat(test, containsString("String lenght is: "));

    }

    @Test
    void testMockedStringLength() {

        Reader target = new Reader();
        ScannerWrapper mockedScanner = mock(ScannerWrapper.class);
        target.setScannerWrapper(mockedScanner);
        when(mockedScanner.read()).thenReturn("Mocking successful");

        String test = target.readString();
        assertThat(test, containsString("18"));

    }
}