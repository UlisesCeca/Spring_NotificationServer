package com.ulises.template.rest.exceptionsmappers;

import com.ulises.template.rest.dto.ErrorDTO;
import com.ulises.template.services.exceptions.UserNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.template.constants.Constants.REQUEST_ERROR_USER_DOESNT_EXOST;

public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
    @Override
    public Response toResponse(UserNotFoundException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(REQUEST_ERROR_USER_DOESNT_EXOST)
                .build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorDTO).build();
    }
}