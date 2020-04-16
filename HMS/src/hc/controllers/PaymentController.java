package hc.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hc.beans.Payment;
import hc.services.AppoinmentService;

@Path("payments")
public class PaymentController {

	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("ROLE_ADMIN")
	public List<Payment> checkPayments() throws Exception {
		return AppoinmentService.getPayments();
	}
}
