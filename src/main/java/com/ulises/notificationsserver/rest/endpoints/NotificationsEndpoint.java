package com.ulises.notificationsserver.rest.endpoints;


import com.ulises.notificationsserver.rest.dto.EmailDTO;
import com.ulises.notificationsserver.rest.mappers.EmailMapper;
import com.ulises.notificationsserver.services.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.ulises.notificationsserver.constants.Constants.ENDPOINT_NOTIFICATIONS;
import static com.ulises.notificationsserver.constants.Constants.ENDPOINT_NOTIFICATIONS_EMAIL;
import static com.ulises.notificationsserver.constants.Constants.REQUEST_ERROR_NULL_BODY;

@Component
@Path(ENDPOINT_NOTIFICATIONS)
public class NotificationsEndpoint {
    @Autowired
    private NotificationsService notificationsService;
    @Autowired
    private EmailMapper emailMapper;


    @POST
    @Path(ENDPOINT_NOTIFICATIONS_EMAIL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmail(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final EmailDTO email) {
        System.out.println(email);
        this.notificationsService.sendEmail(this.emailMapper.map(email));
        return Response.noContent().build();
    }
}
