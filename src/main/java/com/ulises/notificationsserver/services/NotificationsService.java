package com.ulises.notificationsserver.services;

import com.ulises.notificationsserver.services.entities.Email;

public interface NotificationsService {
    void sendEmail(final Email email);
}
