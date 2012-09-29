package org.guess.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.guess.bean.Blog;
import org.guess.dao.BlogDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BlogDaoImpl extends HibernateDaoSupport implements BlogDao {

	@Override
	public Blog saveBlog(Blog blog) {

		this.getHibernateTemplate().save(blog);
		this.getHibernateTemplate().flush();

		return blog;
	}

	@Override
	public void deleteBlog(Blog blog) {

		this.getHibernateTemplate().delete(blog);
	}

	@Override
	public void updataBlog(Blog blog) {

		this.getHibernateTemplate().update(blog);
	}

	@Override
	public Blog getBlogById(int id) {

		return this.getHibernateTemplate().get(Blog.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> listBlog() {

		return this.getHibernateTemplate().find(
				"from Blog blog order by blog.id desc");

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> queryBlog(String queryStr) {

		String hql = "from Blog blog where blog.title like :title or blog.centent like :content or blog.author like :author order by blog.id desc";

		String str = "from Blog blog where blog.title like %" + queryStr
				+ "% or blog.centent like %" + queryStr
				+ "% or blog.author like %" + queryStr
				+ "% order by blog.id desc";

		String s1 = "from Blog blog where blog.title like ? or blog.content like ? or blog.author like ? order by blog.id desc";
		String[] param = { "title", "content", "author" };
		String[] value = { "%" + queryStr + "%", "%" + queryStr + "%",
				"%" + queryStr + "%" };
		return this.getHibernateTemplate().find(
				s1,
				new String[] { "%" + queryStr + "%", "%" + queryStr + "%",
						"%" + queryStr + "%" });
	}

	@Override
	public List<Blog> paging(final int pageIndex, final int pageSize) {

		@SuppressWarnings("unchecked")
		List<Blog> list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						List<Blog> result = session
								.createQuery(
										"from Blog blog order by blog.id desc")
								.setFirstResult(pageIndex)
								.setMaxResults(pageSize).list();
						return result;
					}
				});

		return list;
	}

	@Override
	public Integer countBlog() {
		String hql = "select count(*) from Blog as blog";
		Long count = (Long) getHibernateTemplate().find(hql)
				.listIterator().next();
		return count.intValue();
	}
}
