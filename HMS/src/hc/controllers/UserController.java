package hc.controllers;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import hc.suport.DbContext;

@Path("user")
public class UserController {

	@Path("all")
	@GET
	public String All() throws Exception {
		DbContext.getConnection();
		return "ok";
	}
}
