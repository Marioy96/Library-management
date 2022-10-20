package co.develhope.librarymanagement.notification;

import co.develhope.librarymanagement.inventory.entities.Employee;
import co.develhope.librarymanagement.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendActivationEmail(User user) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("Library.mail@Test");
        sms.setReplyTo("Library.mail@Test");
        sms.setSubject("Ti sei iscritto alla piattaforma");
        sms.setText("Il codice di attivazione è:" + user.getActivationCode());
        javaMailSender.send(sms);
    }

    public void sendActivationEmailForEmployee(Employee employee) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(employee.getEmail());
        sms.setFrom("Library.mail@Test");
        sms.setReplyTo("dLibrary.mail@Test");
        sms.setSubject("Sei stato assunto!");
        sms.setText("Il codice di attivazione è:" + employee.getActivationCode());
        javaMailSender.send(sms);
    }


}
