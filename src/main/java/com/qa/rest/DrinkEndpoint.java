package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IDrinkService;

@Path("/drink")
public class DrinkEndpoint {
	
	@Inject
	private IDrinkService ds;
	
	@Path("/getall")
	@GET
	@Produces({"application/json"})
	public String getAll() {
		return ds.getAll();
	}
	
	@Path("/get/{id}")
	@GET
	@Produces({"application/json"})
	public String get(@PathParam("id") Long id) {
		return ds.find(id).toString();
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces({"application/json"})
	public String delete(@PathParam("id") Long id) {
		return ds.delete(id);
	}

	@Path("/create")
	@POST
	@Produces("application/json")
	public String create(String drink) {
		return ds.create(drink);
	}
	
	@Path("/update/{id}")
	@PUT
	@Produces({"application/json"})
	public String update(@PathParam("id") Long id, String drink) {
		return ds.update(id, drink);
	}
	
	
	public void setService(IDrinkService service) {
		this.ds = service;
	}

}
