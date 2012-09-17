package org.guess.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.guess.bean.Blog;
import org.guess.dao.BlogDao;

@Path("/Blog")
public class BlogService {

	private BlogDao dao;

	public BlogDao getDao() {
		return dao;
	}

	public void setDao(BlogDao dao) {
		this.dao = dao;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listBlog")
	public List<Blog> listBlog() {

		return this.getDao().listBlog();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBlog")
	public Blog getBlog(@Context HttpServletRequest request) {

		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		return this.getDao().getBlogById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/queryBlog")
	public List<Blog> queryBlog(@Context HttpServletRequest request) {

		String queryStr = request.getParameter("queryStr");
		System.out.println(queryStr);
		return this.getDao().queryBlog(queryStr);
	}

}
