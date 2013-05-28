package lt.oworks.serverchecker.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Ovidijus
 */
@XmlType(name = "email")
@XmlAccessorType(XmlAccessType.FIELD)
public class EMailSettings {

    @XmlElement(required = true)
    private String username;
    @XmlElement(required = true)
    private String password;
    private boolean smtpAuth = true;
    private boolean smtpStarttlsEnable = true;
    @XmlElement(required = true)
    private String smtpHost;
    private String smtpPort = "587";
}
