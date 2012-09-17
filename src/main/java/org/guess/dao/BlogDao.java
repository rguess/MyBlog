package org.guess.dao;

import java.util.List;

import org.guess.bean.Blog;

public interface BlogDao {

	public void saveBlog(Blog blog);
	public void deleteBlog(Blog blog);
	public void updataBlog(Blog blog);
	public Blog getBlogById(int id);
	public List<Blog> listBlog();
	public List<Blog> queryBlog(String hql);
}
