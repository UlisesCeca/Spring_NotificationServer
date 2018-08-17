package com.ulises.notificationsserver.rest.exceptionsmappers;

import com.ulises.notificationsserver.rest.dto.ErrorDTO;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.notificationsserver.constants.Constants.REQUEST_ERROR_INTERNAL_SERVER_ERROR;

public class InternalServerErrorMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        /*final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(REQUEST_ERROR_INTERNAL_SERVER_ERROR)
                .build();*/
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity("")
                .build();
    }
}