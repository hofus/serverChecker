package lt.oworks.serverchecker.model.settings;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ovidijus
 */
@XmlRootElement(name = "settings")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppSettings {

    private EMailSettings email;
    private List<ServerSettings> servers;
}
