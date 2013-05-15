package lt.oworks.serverchecker.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ovidijus
 */
@XmlRootElement(name = "email")
@XmlAccessorType(XmlAccessType.FIELD)
public class EMailSettings {

    @XmlAttribute(required = true)
    private String username;
    @XmlAttribute(required = true)
    private String password;
    private boolean smtpAuth = true;
    private boolean smtpStarttlsEnable = true;
    @XmlAttribute(required = true)
    private String smtpHost;
    private String smtpPort = "587";
}
