package lt.oworks.serverchecker;

import java.io.File;
import lt.oworks.serverchecker.control.Controller;
import lt.oworks.serverchecker.control.SettingsLoader;
import lt.oworks.serverchecker.model.settings.AppSettings;
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
            AppSettings settings = SettingsLoader.loadSettings(new File(args[0]));
            new Controller(settings).startCheckers();
        }


    }
}
