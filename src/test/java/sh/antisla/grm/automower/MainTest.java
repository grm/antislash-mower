package sh.antisla.grm.automower;

import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import sh.antisla.grm.automower.models.Mower;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMain() {
        File file = null;
        try {
            file = File.createTempFile("mowItNow", ".conf");
            FileUtils.write(file, "5 5\n" +
                    "1 2 N\n" +
                    "GAGAGAGAA\n" +
                    "3 3 E\n" +
                    "AADAADADDA", "UTF-8");

            Main.main(new String[]{
                    "-f",
                    file.getAbsolutePath()
            });
            assertTrue(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.delete();
                }
            } catch (Exception ex) {

            }
        }
    }

    @Test
    public void testMainWithUnknownFile() {
        try {
            Main.main(new String[]{
                    "-f",
                    "/file/does/not/exists"
            });
            fail("Should not be here !");
        } catch (IOException ex) {
            assertTrue(true);
        } catch (ParseException ex2) {
            fail("Exception 'ParseException' should not be thrown.");
        }
    }

    @Test
    public void testMainWithoutFileOption() {
        try {
            Main.main(new String[]{
            });
            fail("Should not be here !");
        } catch (IOException ex) {
            fail("Exception 'IOException' should not be thrown.");
        } catch (ParseException ex2) {
            assertTrue(true);
            }
    }
}