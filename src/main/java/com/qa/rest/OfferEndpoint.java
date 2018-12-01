package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IOfferService;

@Path("/offer")
public class OfferEndpoint {
	
	@Inject
	private IOfferService os;
	
	@Path("/getall")
	@GET
	@Produces({"application/json"})
	public String getAll() {
		return os.getAll();
	}
	
	@Path("/get/{id}")
	@GET
	@Produces({"application/json"})
	public String get(@PathParam("id") Long id) {
		return os.find(id).toString();
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces({"application/json"})
	public String delete(@PathParam("id") Long id) {
		return os.delete(id);
	}

	@Path("/create")
	@POST
	@Produces("application/json")
	public String create(String offer) {
		return os.create(offer);
	}
	
	@Path("/update/{id}")
	@PUT
	@Produces({"application/json"})
	public String update(@PathParam("id") Long id, String offer) {
		return os.update(id, offer);
	}
	
	
	public void setService(IOfferService service) {
		this.os = service;
	}

}