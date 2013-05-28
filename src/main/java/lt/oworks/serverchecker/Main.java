package lt.oworks.serverchecker;

import java.io.File;
import lt.oworks.serverchecker.model.logic.SettingsLoader;
import org.apache.log4j.BasicConfigurator;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        if (args.length == 0) {
            System.err.println("Need settings file path");
        } else {
            System.out.println("Starting");
        }
        
        SettingsLoader.loadSettings(new File("testXml.xml"));
    }
}
