package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IBreweryService;

@Path("/brewery")
public class BreweryEndpoint {

	@Inject
	private IBreweryService bs;
	
	@Path("/getall")
	@GET
	@Produces({"application/json"})
	public String getAll() {
		return bs.getAll();
	}
	
	@Path("/get/{id}")
	@GET
	@Produces({"application/json"})
	public String get(@PathParam("id") Long id) {
		return bs.find(id).toString();
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces({"application/json"})
	public String delete(@PathParam("id") Long id) {
		return bs.delete(id);
	}

	@Path("/create")
	@POST
	@Produces("application/json")
	public String create(String brewery) {
		return bs.create(brewery);
	}
	
	@Path("/update/{id}")
	@PUT
	@Produces({"application/json"})
	public String update(@PathParam("id") Long id, String brewery) {
		return bs.update(id, brewery);
	}
	
	
	public void setService(IBreweryService service) {
		this.bs = service;
	}		
}