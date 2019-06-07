package sh.antisla.grm.automower;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testFunction() {
        Main main = new Main();
        assertEquals(main.testFunction("teeest"), "teeest");
    }
}