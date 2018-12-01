package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IBarService;

@Path("/bar")
public class BarEndpoint {

	@Inject
	private IBarService bs;
	
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
	
	@Path("/get/longitude={longtitude}/latitude={latitude}/listLength={listLength}")
	@GET
	@Produces({"application/json"})
	public String get(@PathParam("longtitude") double longitude, @PathParam("latitude") double latitude, @PathParam("listLength") int listLength) {
		return bs.getLoLa(longitude, latitude, listLength);
	}
	
	@Path("/get/easting={easting}/northing={northing}/listLength={listLength}")
	@GET
	@Produces({"application/json"})
	public String get(@PathParam("easting") Long easting, @PathParam("northing") Long northing, @PathParam("listLength") int listLength) {
		return bs.getEN(easting, northing, listLength);
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
	public String create(String bar) {
		return bs.create(bar);
	}
	
	@Path("/update/{id}")
	@PUT
	@Produces({"application/json"})
	public String update(@PathParam("id") Long id, String bar) {
		return bs.update(id, bar);
	}
	
	
	public void setService(IBarService service) {
		this.bs = service;
	}
	
	
	
}