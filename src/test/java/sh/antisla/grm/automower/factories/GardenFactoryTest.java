package sh.antisla.grm.automower.factories;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import sh.antisla.grm.automower.models.Garden;
import sh.antisla.grm.automower.models.Mower;
import sh.antisla.grm.automower.models.mower.MowerCardinality;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class GardenFactoryTest {

    @Test
    public void loadFromFile() {
        File file = null;
        try {
            file = File.createTempFile("mowItNow", ".conf");
            FileUtils.write(file, "5 5\n" +
                    "1 2 N\n" +
                    "GAGAGAGAA\n" +
                    "3 3 E\n" +
                    "AADAADADDA", "UTF-8");

            Garden garden = GardenFactory.loadFromFile(file);
            garden.mowItNow();

            Mower mower1 = garden.getMowers().get(0);
            assertEquals(1, mower1.getPosition().getPositionX());
            assertEquals(3, mower1.getPosition().getPositionY());
            assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());

            Mower mower2 = garden.getMowers().get(1);
            assertEquals(5, mower2.getPosition().getPositionX(), 5);
            assertEquals(1, mower2.getPosition().getPositionY(), 1);
            assertEquals(MowerCardinality.E, mower2.getPosition().getOrientation());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.delete();
                }
            } catch (Exception ex) {

            }
        }
    }
}