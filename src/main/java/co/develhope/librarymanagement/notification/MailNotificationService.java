package co.develhope.librarymanagement.notification;

import co.develhope.librarymanagement.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendActivationMail(User user){
        //TODO
    }
}
