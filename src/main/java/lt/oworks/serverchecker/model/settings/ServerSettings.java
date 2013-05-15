package lt.oworks.serverchecker.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ovidijus
 */
@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServerSettings {

    @XmlAttribute(required = true)
    private String emailFrom;
    @XmlAttribute(required = true)
    private String emailTo;
    @XmlAttribute(required = true)
    private String emailSubject;
    @XmlAttribute(required = true)
    private String emailMessage;
    @XmlAttribute(required = true)
    private String serverUrl;
    private int timeout = 1000;
    private int interval = 60 * 1000;
}
