package com.ulises.notificationsserver.rest.mappers;

import com.ulises.notificationsserver.rest.dto.EmailDTO;
import com.ulises.notificationsserver.services.entities.Email;
import com.ulises.notificationsserver.services.entities.EmailBuilder;

public class EmailMapper implements EmailMapperImpl {
    @Override
    public Email map(EmailDTO dto) {
        return EmailBuilder.builder()
                .to(dto.getTo())
                .from(dto.getFrom())
                .cc(dto.getCc())
                .bcc(dto.getBcc())
                .body(dto.getBody())
                .subject(dto.getSubject())
                .context(dto.getContext())
                .build();
    }
}
