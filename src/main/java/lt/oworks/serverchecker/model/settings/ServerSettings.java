package lt.oworks.serverchecker.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ovidijus
 */
@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServerSettings {

    @XmlElement(required = true)
    private String emailFrom;
    @XmlElement(required = true)
    private String emailTo;
    @XmlElement(required = true)
    private String emailSubject;
    @XmlElement(required = true)
    private String emailMessage;
    @XmlElement(required = true)
    private String serverUrl;
    private int timeout = 1000;
    private int interval = 60 * 1000;
}
