import com.sun.tools.javac.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FZI_STEFTest {
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
        final String testString = "5 1 -2 4 5 -2";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("9", getOutput().trim());
    }
    @Test
    public void mainTest2() {
        final String testString = "2 -1 -2";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("0", getOutput().trim());
    }
    @Test
    public void mainTest3() {
        final String testString = "10 -1 -2 5 -1 -4 8 -3 -6 10 -10";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("10", getOutput().trim());
    }
    @Test
    public void mainTest4() {
        final String testString = "5 -1 5 -5 2 2";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("5", getOutput().trim());
    }
    @Test
    public void mainTest5() {
        final String testString = "5 -1 4 -5 2 3";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("5", getOutput().trim());
    }
    @Test
    public void mainTest6() {
        final String testString = "5 -1 -4 -5 -2 -1";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("0", getOutput().trim());
    }
    @Test
    public void mainTest7() {
        final String testString = "5 -1 -4 1 -2 -1";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("1", getOutput().trim());
    }
    @Test
    public void mainTest8() {
        final String testString = "5 3 3 -5 8 -3";
        provideInput(testString);
        FZI_STEF.main(new String[0]);
        assertEquals("9", getOutput().trim());
    }
}
