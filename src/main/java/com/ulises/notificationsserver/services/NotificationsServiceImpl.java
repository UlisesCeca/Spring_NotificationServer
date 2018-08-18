package com.ulises.notificationsserver.services;

import com.ulises.notificationsserver.services.entities.Email;
import com.ulises.notificationsserver.services.repositories.EmailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationsServiceImpl implements NotificationsService{
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private EmailsRepository emailsRepository;

    @Override
    public void sendEmail(final Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getFrom());
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        if(email.getCc().size() > 0)
            message.setCc(email.getCc().toArray(new String[email.getCc().size()]));
        if(email.getBcc().size() > 0)
            message.setBcc(email.getBcc().toArray(new String[email.getBcc().size()]));
        emailSender.send(message);
        this.emailsRepository.insert(email);
    }
}