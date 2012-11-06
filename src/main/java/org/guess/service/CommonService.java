package org.guess.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public interface CommonService<T>{

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveOrUpdate(T entity);
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id);
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id);
	
	@GET
	public Response listAll();
	
	@GET
	@Path("/list")
	public Response listForPage(@Context UriInfo uriInfo);
	
	@GET
	@Path("/list/count")
	public Response getListCount(@Context UriInfo uriInfo);
}
