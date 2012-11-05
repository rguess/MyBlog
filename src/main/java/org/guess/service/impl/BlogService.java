package org.guess.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.guess.bean.Blog;
import org.guess.core.HibernateDao;
import org.guess.service.CommonService;

@Path("/blog")
public class BlogService implements CommonService<Blog>{
	
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
	@Path("id")
	public Response delete(int id) {

		Blog blog = dao.getById(Blog.class, id);
		dao.delete(Blog.class, blog);
		return null;
	}

	@Override
	@GET
	@Path("/id")
	public Response getById(int id) {
		
		return Response.ok(dao.getById(Blog.class, id), MediaType.APPLICATION_JSON).build();
	}

	@Override
	@GET
	public Response listAll() {
		
		return Response.ok(dao.getAll(Blog.class, null, null), MediaType.APPLICATION_JSON).build();
	}

	@Override
	@GET
	@Path("/list")
	public Response listForPage(UriInfo uriInfo) {
		
		return null;
	}

	@Override
	@GET
	@Path("/list/count")
	public Response getListCount(UriInfo uriInfo) {
		// TODO Auto-generated method stub
		return null;
	}

//	private static final Log _log = LogFactory.getLog(BlogService.class);
//
//	private BlogDao dao;
//
//	private HibernateDao hdaDao;
//
//	public void setHdaDao(HibernateDao hdaDao) {
//		this.hdaDao = hdaDao;
//	}
//
//	public void setDao(BlogDao dao) {
//		this.dao = dao;
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Blog> listBlog() {
//		return hdaDao.getAll(Blog.class, null, null);
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{id}")
//	public Blog getBlog(@PathParam("id") int id) {
//		return hdaDao.getById(Blog.class, id);
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/query/{str}")
//	public List<Blog> queryBlog(@PathParam("str") String str) {
//
//		return dao.queryBlog(str);
//	}
//
//	@POST
//	@Produces(MediaType.TEXT_HTML)
//	public String saveBlog(@FormParam("title") String title,
//			@FormParam("content") String content) {
//
//		Blog blog = new Blog();
//		blog.setTitle(title);
//		blog.setContent(content);
//		blog.setAuthor("韩寒");
//		blog.setTime(TimeTools.getCurrentTimeNoSeconds());
//
//		int id = dao.saveBlog(blog).getId();
//		System.out.println("id==============" + id);
//		return String.valueOf(id);
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/listForPage")
//	public List<Blog> pageBlog(@FormParam("pageIndex") int pageIndex,
//			@FormParam("pagesize") int pagesize) {
//
//		System.out.println(pageIndex);
//		System.out.println(pagesize);
//		_log.info("列出清单");
//		return dao.paging(pageIndex, pagesize);
//
//	}
//
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	@Path("/listForPageCount")
//	public Integer countBlog() {
//		return dao.countBlog();
//	}

}
