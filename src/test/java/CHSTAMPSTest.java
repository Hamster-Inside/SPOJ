import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CHSTAMPSTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void mainTest1() {
        final String testString = "595 2";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("655", getOutput().trim());
    }

    @Test
    public void mainTest2() {
        final String testString = "595234212399009 3";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("595234212399015", getOutput().trim());
    }

    @Test
    public void mainTest3() {
        final String testString = "9999 3";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("10555", getOutput().trim());
    }

    @Test
    public void mainTest4() {
        final String testString = "99995 3";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("100555", getOutput().trim());
    }

    @Test
    public void mainTest5() {
        final String testString = "99995 2";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("100055", getOutput().trim());
    }

    @Test
    public void mainTest6() {
        final String testString = "49695 2";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("49755", getOutput().trim());
    }

    @Test
    public void mainTest7() {
        final String testString = "49695 4";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("50555", getOutput().trim());
    }

    @Test
    public void mainTest8() {
        final String testString = "987654321 8";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("1055555555", getOutput().trim());
    }

    @Test
    public void mainTest9() {
        final String testString = "494949949 7";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("495555555", getOutput().trim());
    }

    @Test
    public void mainTest10() {
        final String testString = "494949949 8";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("505555555", getOutput().trim());
    }

    @Test
    public void mainTest11() {
        final String testString = "55 1";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("56", getOutput().trim());
    }

    @Test
    public void mainTest12() {
        final String testString = "5 1";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("15", getOutput().trim());
    }

    @Test
    public void mainTest13() {
        final String testString = "15 1";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("25", getOutput().trim());
    }

    @Test
    public void mainTest14() {
        final String testString = "51 1";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("52", getOutput().trim());
    }

    @Test
    public void mainTest15() {
        final String testString = "6666 4";
        provideInput(testString);
        CHSTAMPS.main(new String[0]);
        assertEquals("15555", getOutput().trim());
    }
}


