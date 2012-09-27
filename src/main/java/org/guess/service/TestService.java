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
		blog.setTitle("我的第一篇博客");

		StringBuilder sb = new StringBuilder();
//		sb.append("This is Sky Blue, a standards-compliant CSS template designed by 100 Web"
//				+ " Hosting. This web template is released under a Creative Commons Attribution 3.0 license,"
//				+ " so you are free to use it for your website (even use it commercially) provided you keep "
//				+ "the links in the <p class='meta'>footer</p><a href='http://www.baidu.com'>baidu</a> intact. Other than that, you can customize it freely."
//				+ "If you plan to get a web hosting plan, make sure you check out 100 Web Hosting "
//				+ "- an independent web hosting reviews, ratings and comparison resource.");
		
		sb.append("问题是这样的，同事在eclipse中开发的项目，导成jar之后，放到服务器上，总是报“Unsupported major.minor version 51.0”的错误，从网上查，一直说是JDK的问题，但是就不是很清楚怎么回事，怎么解决，最后，经过另一个同事，终于解决了，也使我终于明白了问题的来龙去脉：在eclipse中开发的项目有个java build path中可以配置的jdk，还有个java compiler中可以配置compiler level，这两个是有区别的，build path的JDK版本是你开发的时候编译器需要使用到的，就是你在eclipse中开发代码，给你提示报错的，编译的过程；java compiler compliance level中配置的编译版本号，这个编译版本号的作用是，你这个项目将来开发完毕之后，要放到服务器上运行，那个服务器上JDK的运行版本。同事的问题就是，build path中配置1.7的JDK，java compiler compliance level中配置的1.7，但是服务器上是1.6的JDK，就报了那个错误，说是编译所用的jdk（1.7）比运行所用的jdk（1.6）高了，这是错误的。");
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
//		return this.getDao().queryBlog("");
		return this.getDao().paging(0,3);
	}
}
