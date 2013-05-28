package lt.oworks.serverchecker.model.logic;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import lt.oworks.serverchecker.model.settings.AppSettings;
import org.apache.log4j.Logger;

/**
 *
 * @author Ovidijus
 */
public class SettingsLoader {

    private static final Logger LOG = Logger.getLogger(SettingsLoader.class);

    public static AppSettings loadSettings(final File pFile) {
        AppSettings appSettings = null;
        try {
            final JAXBContext ctx = JAXBContext.newInstance(AppSettings.class);
            final Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Object settings = unmarshaller.unmarshal(pFile);
            appSettings = (AppSettings) settings;
        } catch (JAXBException ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return appSettings;
    }
}
