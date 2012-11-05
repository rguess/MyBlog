package org.guess.service.impl;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.guess.bean.Blog;
import org.guess.core.HibernateDao;
import org.guess.dao.BlogDao;
import org.guess.util.TimeTools;

@Path("/blog")
public class BlogService {

	private static final Log _log = LogFactory.getLog(BlogService.class);

	private BlogDao dao;

	private HibernateDao hdaDao;

	public void setHdaDao(HibernateDao hdaDao) {
		this.hdaDao = hdaDao;
	}

	public void setDao(BlogDao dao) {
		this.dao = dao;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Blog> listBlog() {
		return hdaDao.getAll(Blog.class, null, null);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Blog getBlog(@PathParam("id") int id) {
		return hdaDao.getById(Blog.class, id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/query/{str}")
	public List<Blog> queryBlog(@PathParam("str") String str) {

		return dao.queryBlog(str);
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String saveBlog(@FormParam("title") String title,
			@FormParam("content") String content) {

		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setContent(content);
		blog.setAuthor("韩寒");
		blog.setTime(TimeTools.getCurrentTimeNoSeconds());

		int id = dao.saveBlog(blog).getId();
		System.out.println("id==============" + id);
		return String.valueOf(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listForPage")
	public List<Blog> pageBlog(@FormParam("pageIndex") int pageIndex,
			@FormParam("pagesize") int pagesize) {

		System.out.println(pageIndex);
		System.out.println(pagesize);
		_log.info("列出清单");
		return dao.paging(pageIndex, pagesize);

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/listForPageCount")
	public Integer countBlog() {
		return dao.countBlog();
	}

}
