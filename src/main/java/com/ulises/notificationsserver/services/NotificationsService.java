package com.ulises.notificationsserver.services;

import com.ulises.notificationsserver.services.entities.Email;

public interface NotificationsService {
    void recoverPasswordByEmail(final Email email);
}
