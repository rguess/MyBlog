package org.guess.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.guess.bean.Blog;
import org.guess.core.HibernateDao;
import org.guess.service.CommonService;

@Path("/blog")
public class BlogService implements CommonService<Blog> {

	private HibernateDao dao;

	public void setDao(HibernateDao dao) {
		this.dao = dao;
	}

	@Override
	@POST
	@Consumes("application/json")
	public Response saveOrUpdate(Blog entity) {

		Blog blog = dao.saveOrUpdate(Blog.class, entity);
		return Response.ok(blog.getId(), MediaType.TEXT_HTML).build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Blog blog = dao.getById(Blog.class, id);
		dao.delete(Blog.class, blog);
		return null;
	}

	@Override
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id) {
		return Response.ok(dao.getById(Blog.class, id),
				MediaType.APPLICATION_JSON).build();
	}

	@Override
	@GET
	public Response listAll() {

		return Response.ok(dao.getAll(Blog.class, null, null),
				MediaType.APPLICATION_JSON).build();
	}

	@Override
	@GET
	@Path("/list")
	public Response listForPage(@Context UriInfo uriInfo) {
		MultivaluedMap<String, String> params = uriInfo.getQueryParameters();

		Map<String, String> likeCondition = new HashMap<String, String>();
		likeCondition.put("author", params.getFirst("author"));
		likeCondition.put("title", params.getFirst("title"));
		likeCondition.put("content", params.getFirst("content"));
		List<Blog> list = dao.getListForPage(Blog.class, 0, 20, null,
				likeCondition);
		return Response.ok(list, MediaType.APPLICATION_JSON).build();
	}

	@Override
	@GET
	@Path("/list/count")
	public Response getListCount(@Context UriInfo uriInfo) {
		MultivaluedMap<String, String> params = uriInfo.getQueryParameters();

		Map<String, String> likeCondition = new HashMap<String, String>();
		likeCondition.put("author", params.getFirst("author"));
		likeCondition.put("title", params.getFirst("title"));
		likeCondition.put("content", params.getFirst("content"));
		long count = dao.getListCount(Blog.class, null, likeCondition);
		return Response.ok(count,MediaType.TEXT_HTML).build();
	}

}
