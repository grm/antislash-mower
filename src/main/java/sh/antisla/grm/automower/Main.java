package sh.antisla.grm.automower;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.antisla.grm.automower.factories.GardenFactory;
import sh.antisla.grm.automower.models.Garden;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException{
        try {
            final Option fileOption = Option.builder("f")
                    .longOpt("file") //
                    .desc("file: specify the mowing planner description")
                    .hasArg(true)
                    .argName("file")
                    .required(true)
                    .build();
            final Options options = new Options();
            options.addOption(fileOption);

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            String file = cmd.getOptionValue("file");

            if (file != null) {
                Garden garden = GardenFactory.loadFromFile(new File(file));
                garden.mowItNow();
            }
        } catch (ParseException ex) {
            logger.error("Could not parse cmd line", ex);
            throw ex;
        } catch (IOException ex2) {
            logger.error("IOException while reading file", ex2);
            throw ex2;
        }
    }
}
