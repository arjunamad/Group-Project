package hc.controllers;

import java.sql.Date;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import hc.beans.Appoinment;
import hc.beans.DoctorSession;
import hc.beans.SingleResponse;
import hc.beans.User;
import hc.services.DoctorService;

@Path("doctors")
public class DoctorCntroller {

	@Path("sessions/{doctorId}/{day}")
	@GET
	@RolesAllowed("ROLE_DOCTOR")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorSession> sessions(@Context ContainerRequestContext crc, @PathParam("doctorId") Long doctorId,
			@PathParam("day") String day) throws Exception {
		return DoctorService.getDessions(doctorId, day);
	}

	@Path("all")
	@GET
	@RolesAllowed("ROLE_DOCTOR")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> all() throws Exception {
		return DoctorService.all();
	}

	@Path("appos/{date}")
	@GET
	@RolesAllowed("ROLE_DOCTOR")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appoinment> appos(@PathParam("date") Date date, @Context ContainerRequestContext crc) throws Exception {
		return DoctorService.getApposOfDate(date, crc.getProperty("username").toString());
	}
	
	@PathParam("crete-session")
	@POST
	@RolesAllowed("ROLE_DOCTOR")
	@Produces(MediaType.APPLICATION_JSON)
	public SingleResponse creteSession(DoctorSession session,@Context ContainerRequestContext crc) throws Exception{
		try {
			DoctorService.createSession(session, crc.getProperty("username").toString());
			return SingleResponse.ok("Success");
		} catch (Exception e) {
			return SingleResponse.error(e);
		}
	}
}
