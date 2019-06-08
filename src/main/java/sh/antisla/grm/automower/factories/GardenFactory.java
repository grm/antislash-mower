package sh.antisla.grm.automower.factories;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.antisla.grm.automower.models.Garden;
import sh.antisla.grm.automower.models.Mower;
import sh.antisla.grm.automower.models.mower.MowerCardinality;
import sh.antisla.grm.automower.models.mower.MowerPosition;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GardenFactory {

    private static final Logger logger = LoggerFactory.getLogger(GardenFactory.class);


    public static Garden loadFromFile(File file) throws IOException {
        logger.debug("Reading from file {}", file.getAbsolutePath());
        List<String> lines = FileUtils.readLines(file, "UTF-8");

        String[] gridInformation = lines.get(0).split(" ");
        int gridX = Integer.parseInt(gridInformation[0]);
        int gridY = Integer.parseInt(gridInformation[1]);

        Garden garden = new Garden(gridX, gridY);

        for (int i = 1; i < lines.size(); ) {
            String[] positionInfo = lines.get(i++).split(" ");
            int positionX = Integer.parseInt(positionInfo[0]);
            int positionY = Integer.parseInt(positionInfo[1]);
            MowerCardinality positionOrientation = MowerCardinality.valueOf(positionInfo[2]);
            MowerPosition position = new MowerPosition(positionX, positionY, positionOrientation);

            String mowerPlanning = lines.get(i++);
            Mower mower = new Mower(position, mowerPlanning, garden);

            garden.addMower(mower);
        }
        return garden;
    }
}
