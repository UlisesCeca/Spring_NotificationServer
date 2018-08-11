package com.ulises.template.rest.endpoints;

import com.ulises.template.rest.dto.ResponseOKDTO;
import com.ulises.template.rest.dto.UserDTO;
import com.ulises.template.services.entities.User;
import com.ulises.template.services.UserService;
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

import static com.ulises.template.constants.Constants.*;

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
