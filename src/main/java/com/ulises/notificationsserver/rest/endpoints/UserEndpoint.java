package com.ulises.notificationsserver.rest.endpoints;

import com.ulises.notificationsserver.rest.dto.ResponseOKDTO;
import com.ulises.notificationsserver.rest.dto.UserDTO;
import com.ulises.notificationsserver.services.entities.User;
import com.ulises.notificationsserver.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.ulises.notificationsserver.constants.Constants.*;

@Component
@Path(ENDPOINT_USERS)
public class UserEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @POST
    @Path(ENDPOINT_USERS_GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final UserDTO testDTO) {
        this.userService.getUser(this.modelMapper.map(testDTO, User.class));
        return Response.ok(ResponseOKDTO.builder().message(RESPONSE_OK_USER_CREATED).build()).build();
    }

}
