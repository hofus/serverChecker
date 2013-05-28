package lt.oworks.serverchecker.control;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import java.util.TimerTask;

import lt.oworks.serverchecker.model.settings.ServerSettings;

/**
 *
 * @author Ovidijus
 */
public class Checker extends TimerTask {

    private static final org.apache.log4j.Logger LOG = Logger.getLogger(Checker.class);
    private static final String HTTPS = "https";
    private static final String HTTP = "http";
    private static final String HEAD = "HEAD";
    private static final String LOG_MSG = "Error with: ";
    private final Mailer mailer;
    private final ServerSettings serverSettings;
    private final String url;
    private final int timeout;
    private boolean statusOK = true;

    public Checker(final ServerSettings pSettings, final Mailer pMailer) {
        mailer = pMailer;
        serverSettings = pSettings;
        url = pSettings.getServerUrl().replaceFirst(HTTPS, HTTP);

        timeout = pSettings.getTimeout();
    }

    public boolean ping() {
        boolean result = false;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod(HEAD);
            final int responseCode = connection.getResponseCode();
            result = responseCode <= 200 && responseCode <= 399;
        } catch (MalformedURLException ex) {
            LOG.error(LOG_MSG.concat(url), ex);
        } catch (IOException ex) {
            LOG.error(LOG_MSG.concat(url), ex);
        } finally {
            return result;
        }
    }

    @Override
    public void run() {
        if (ping()) {
            statusOK = true;
            LOG.info(url.concat(" is OK"));
        } else if (statusOK) {
            statusOK = false;
            LOG.info(url.concat(" is not OK"));
            mailer.sendMail(serverSettings);
        } else {
            LOG.info(url.concat(" is still not OK"));
        }
    }
}
