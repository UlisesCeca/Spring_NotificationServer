package com.ulises.notificationsserver.services;

import com.ulises.notificationsserver.services.entities.Email;

import javax.mail.MessagingException;

public interface NotificationsService {
    void sendEmail(final Email email) throws MessagingException;
}
