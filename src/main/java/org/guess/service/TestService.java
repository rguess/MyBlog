package org.guess.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.guess.bean.Blog;
import org.guess.dao.BlogDao;
import org.guess.util.TimeTools;

@Path("/test")
public class TestService {

	private BlogDao dao;

	public BlogDao getDao() {
		return dao;
	}

	public void setDao(BlogDao dao) {
		this.dao = dao;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/get")
	public String helloworld() {
		Blog blog = new Blog();
		blog.setAuthor("hello");

		blog.setTime(TimeTools.getCurrentTimeNoSeconds());
		blog.setTitle("hello world");

		StringBuilder sb = new StringBuilder();
		sb.append("This is Sky Blue, a standards-compliant CSS template designed by 100 Web"
				+ " Hosting. This web template is released under a Creative Commons Attribution 3.0 license,"
				+ " so you are free to use it for your website (even use it commercially) provided you keep "
				+ "the links in the <p class='meta'>footer</p><a href='http://www.baidu.com'>baidu</a> intact. Other than that, you can customize it freely."
				+ "If you plan to get a web hosting plan, make sure you check out 100 Web Hosting "
				+ "- an independent web hosting reviews, ratings and comparison resource.");
		sb.append("刚盘点了一下，我家除了一台下片子用的笔记本，其他一概都不是日货，倒不是故意抵制，而是这两年日货确实没什么优势，可能跟创造力下降有关吧？电器，国货质量也不赖，不差钱的买欧洲货。。。");
		blog.setContent(sb.toString());
		this.getDao().saveBlog(blog);

		// Blog blog = this.getDao().getBlogById(1);
		// System.out.println(blog.getAuthor());
		// System.out.println(blog.getTime().toString());
		// System.out.println(new Date().toString());
		return "hello world!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listBlog")
	public List<Blog> getBySql(){
		
//		List<Blog> list = this.getDao().findBySql();
//		for(Blog blog:list){
//			System.out.println(blog.getContent());
//		}
		return this.getDao().queryBlog("");
	}
}
