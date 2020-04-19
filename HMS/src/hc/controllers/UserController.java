package hc.controllers;


import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hc.beans.SingleResponse;
import hc.beans.User;
import hc.services.UserService;

@Path("user")
public class UserController {

	@Path("signup")
	@POST
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SingleResponse All(User user) throws Exception {
		 try {
			 UserService.signUp(user);
			return SingleResponse.ok("Success");
		} catch (Exception e) {
			return SingleResponse.error(e);
		}
	}
}
