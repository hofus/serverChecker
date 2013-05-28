package lt.oworks.serverchecker.control;

import java.util.Timer;
import java.util.TimerTask;
import lt.oworks.serverchecker.model.settings.AppSettings;
import lt.oworks.serverchecker.model.settings.ServerSettings;
import org.apache.log4j.Logger;

/**
 *
 * @author Ovidijus
 */
public class Controller {

    private static final Logger LOG = Logger.getLogger(Controller.class);
    private final AppSettings settings;
    private final Mailer mailer;

    public Controller(AppSettings pSettings) {
        settings = pSettings;

        mailer = new Mailer(settings.getEmail());
    }

    public void startCheckers() {

        for (ServerSettings ss : settings.getServers()) {
            if (!ss.isIgnored()) {
                Timer timer = new Timer(ss.getServerUrl());
                timer.schedule(new Checker(ss, mailer), 0, ss.getInterval());
                LOG.info(ss.getServerUrl().concat(" | started"));
            } else {
                LOG.info(ss.getServerUrl().concat(" | ignored"));
            }
        }
    }
}
