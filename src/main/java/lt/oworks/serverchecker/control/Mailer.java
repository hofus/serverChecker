package lt.oworks.serverchecker.control;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lt.oworks.serverchecker.model.settings.EMailSettings;
import lt.oworks.serverchecker.model.settings.ServerSettings;
import org.apache.log4j.Logger;

/**
 *
 * @author Ovidijus
 */
public class Mailer {

    private static final Logger LOG = Logger.getLogger(Mailer.class);
    private static final String SEPARATOR = "\n-----------------------------------\n";
    private final EMailSettings mailSettings;
    private final Session session;

    public Mailer(final EMailSettings pMailSettings) {
        mailSettings = pMailSettings;
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", Boolean.toString(mailSettings.isSmtpAuth()));
        props.setProperty("mail.smtp.starttls.enable", Boolean.toString(mailSettings.isSmtpStarttlsEnable()));
        props.setProperty("mail.smtp.host", mailSettings.getSmtpHost());
        props.setProperty("mail.smtp.port", mailSettings.getSmtpPort());

        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailSettings.getUsername(), mailSettings.getPassword());
            }
        });
    }

    public synchronized void sendMail(final ServerSettings pServerSettings) {
        final String from = pServerSettings.getEmailFrom();
        final String to = pServerSettings.getEmailTo();
        final String subject = pServerSettings.getEmailSubject();
        final StringBuilder text = new StringBuilder(pServerSettings.getEmailMessage());
        text.append(SEPARATOR).append(pServerSettings.getServerUrl()).append(SEPARATOR);

        final Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text.toString());

            Transport.send(message);
        } catch (MessagingException ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }
}
