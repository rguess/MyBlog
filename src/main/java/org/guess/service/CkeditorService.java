package org.guess.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.guess.bean.Blog;
import org.guess.dao.BlogDao;
import org.guess.util.TimeTools;

@Path("/ckeditor")
public class CkeditorService {
	
	private BlogDao dao;

	public BlogDao getDao() {
		return dao;
	}

	public void setDao(BlogDao dao) {
		this.dao = dao;
	}

	@Path("/save")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public void saveBlog(@FormParam("editor1") String content,
			@FormParam("title") String title,
			@Context HttpServletResponse response) {
		System.out.println(content);
		try {
			Blog blog = new Blog();
			blog.setTitle(title);
			blog.setContent(content);
			blog.setAuthor("rguess");
			blog.setTime(TimeTools.getCurrentTimeNoSeconds());
			int id = this.getDao().saveBlog(blog).getId();
			response.sendRedirect("/blog/showblog.html?id="+id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
