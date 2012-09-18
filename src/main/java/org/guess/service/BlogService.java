package org.guess.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.guess.bean.Blog;
import org.guess.dao.BlogDao;
import org.guess.util.TimeTools;

@Path("/Blog")
public class BlogService {

	private static final Log _log = LogFactory.getLog(BlogService.class);
	
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
		
		_log.info("列出清单");
		return this.getDao().listBlog();
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBlog")
	public Blog getBlog(@Context HttpServletRequest request) {
		
		_log.info("通过id获取博客信息");
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		return this.getDao().getBlogById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/queryBlog")
	public List<Blog> queryBlog(@Context HttpServletRequest request) {
		
		_log.info("查询Blog");
		String queryStr = request.getParameter("queryStr");
		System.out.println(queryStr);
		return this.getDao().queryBlog(queryStr);
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("/saveBlog")
	public String saveBlog(@Context HttpServletRequest request,
			@FormParam("title") String title,
			@FormParam("content") String content) {

//		System.out.println(title);
//		System.out.println(content);
		
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setContent(content);
		blog.setAuthor("韩寒");
		blog.setTime(TimeTools.getCurrentTimeNoSeconds());
		
		
		int id = this.getDao().saveBlog(blog).getId();
		System.out.println("id=============="+id);
		return String.valueOf(id);
	}

}
