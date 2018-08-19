package com.ulises.notificationsserver.services;

import com.ulises.notificationsserver.services.entities.Email;
import com.ulises.notificationsserver.services.repositories.EmailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class NotificationsServiceImpl implements NotificationsService{
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private EmailsRepository emailsRepository;

    @Override
    public void sendEmail(final Email email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(email.getBody(), true);
        if(email.getCc().size() > 0)
            helper.setCc(email.getCc().toArray(new String[email.getCc().size()]));
        if(email.getBcc().size() > 0)
            helper.setBcc(email.getBcc().toArray(new String[email.getBcc().size()]));

        emailSender.send(message);

        this.emailsRepository.insert(email);
    }
}