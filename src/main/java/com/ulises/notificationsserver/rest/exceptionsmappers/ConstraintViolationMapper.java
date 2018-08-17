package com.ulises.notificationsserver.rest.exceptionsmappers;

import com.ulises.notificationsserver.rest.dto.ErrorDTO;
import com.ulises.notificationsserver.rest.dto.ErrorDTOBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        final ErrorDTOBuilder builder = ErrorDTOBuilder.builder();
        final ErrorDTO errorDTO;
        for (ConstraintViolation constraintViolation : exception.getConstraintViolations()) {
            builder.addMessage(constraintViolation.getMessage());
        }
        errorDTO = builder.build();
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errorDTO)
                .build();
    }
}