package lt.oworks.serverchecker.model.settings;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ovidijus
 */
@XmlRootElement(name = "settings")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppSettings {

    @XmlElement(name = "email")
    private EMailSettings email;
    @XmlElementWrapper(name = "servers")
    @XmlElement(name = "server")
    private List<ServerSettings> servers;

    public EMailSettings getEmail() {
        return email;
    }

    public void setEmail(EMailSettings email) {
        this.email = email;
    }

    public List<ServerSettings> getServers() {
        return servers;
    }

    public void setServers(List<ServerSettings> servers) {
        this.servers = servers;
    }
}
