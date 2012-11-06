package org.guess.dao;

import java.util.List;

import org.guess.bean.Blog;
import org.guess.core.HibernateDao;

public interface BlogDao{

	public Blog saveBlog(Blog blog);
	public void deleteBlog(Blog blog);
	public void updataBlog(Blog blog);
	public Blog getBlogById(int id);
	public List<Blog> listBlog();
	public List<Blog> queryBlog(String hql);
	public List<Blog> paging(int pageIndex,int pageSize);
	public Integer countBlog();
}
