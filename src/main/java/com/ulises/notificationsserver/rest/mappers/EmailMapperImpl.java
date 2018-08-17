package com.ulises.notificationsserver.rest.mappers;

import com.ulises.notificationsserver.rest.dto.EmailDTO;
import com.ulises.notificationsserver.services.entities.Email;

public interface EmailMapperImpl {
    Email map(final EmailDTO dto);
}
