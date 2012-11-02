package org.gues.core;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao{

	@Override
	public <T> void saveOrUpdate(Class<T> clazz, Object entity) {

		this.getHibernateTemplate().saveOrUpdate(clazz.getName(),entity);
	}

	@Override
	public <T> void delete(Class<T> clazz, Object entity) {
		
		this.getHibernateTemplate().delete(clazz.getName(), entity);
	}

	@Override
	public <T> void deleteById(Class<T> clazz, int id) {

		this.getHibernateTemplate().delete(clazz.getName(), getById(clazz, id));
		
	}

	@Override
	public <T> T getById(Class<T> clazz, int id) {

		return this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public <T> List<T> getListForPage(final Class<T> clazz, final int offset, final int length, final Map<String, String> equalCondition, final Map<String, String> likeCondition) {
		@SuppressWarnings("unchecked")
		List<T> list = super.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(clazz);
				try {
					if (equalCondition != null) {
						Set<String> keySet = equalCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = equalCondition.get(key);
							if(clazz.getDeclaredField(key).getType().getName().equals("int")){
								crit.add(Restrictions.eq(key, Integer.parseInt(value)));
							} else if (clazz.getDeclaredField(key).getType().getName().equals("double")) {
								crit.add(Restrictions.eq(key, Double.parseDouble(value)));
							} else if(clazz.getDeclaredField(key).getType().getName().equals("float")) {
								crit.add(Restrictions.eq(key, Float.parseFloat(value)));
							} else {
								crit.add(Restrictions.eq(key, value));
							}
						}
					}
					if(likeCondition != null) {
						Set<String> keySet = likeCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = likeCondition.get(key);
							if(value != null) {
								crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
							}
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
				crit.addOrder(Order.desc("id"));
				crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				crit.setFirstResult(offset);
				crit.setMaxResults(length);
				List<T> page = crit.list();
				return page;
			}

		});
		return list;
	}

	@Override
	public <T> long getListCount(final Class<T> clazz, final Map<String, String> equalCondition, final Map<String, String> likeCondition) {
		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {

			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(clazz);
				crit.setProjection(Projections.rowCount());
				try {
					if (equalCondition != null) {
						Set<String> keySet = equalCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = equalCondition.get(key);
							if(clazz.getDeclaredField(key).getType().getName().equals("int")){
								crit.add(Restrictions.eq(key, Integer.parseInt(value)));
							} else if (clazz.getDeclaredField(key).getType().getName().equals("double")) {
								crit.add(Restrictions.eq(key, Double.parseDouble(value)));
							} else if(clazz.getDeclaredField(key).getType().getName().equals("float")) {
								crit.add(Restrictions.eq(key, Float.parseFloat(value)));
							} else {
								crit.add(Restrictions.eq(key, value));
							}
						}
					}
					if(likeCondition != null) {
						Set<String> keySet = likeCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = likeCondition.get(key);
							if(value != null) {
								crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
							}
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
				return (Long) crit.uniqueResult();
			}

		});
		return count == null ? 0 : count.longValue();
	}

	@Override
	public <T> List<T> getAll(final Class<T> clazz, final Map<String, String> equalCondition, final Map<String, String> likeCondition) {
		@SuppressWarnings("unchecked")
		List<T> list = super.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(clazz);
				try {
					if (equalCondition != null) {
						Set<String> keySet = equalCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = equalCondition.get(key);
							if(clazz.getDeclaredField(key).getType().getName().equals("int")){
								crit.add(Restrictions.eq(key, Integer.parseInt(value)));
							} else if (clazz.getDeclaredField(key).getType().getName().equals("double")) {
								crit.add(Restrictions.eq(key, Double.parseDouble(value)));
							} else if(clazz.getDeclaredField(key).getType().getName().equals("float")) {
								crit.add(Restrictions.eq(key, Float.parseFloat(value)));
							} else {
								crit.add(Restrictions.eq(key, value));
							}
						}
					}
					if(likeCondition != null) {
						Set<String> keySet = likeCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = likeCondition.get(key);
							if(value != null) {
								crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
							}
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
				crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				List<T> page = crit.list();
				return page;
			}

		});
		return list;
	}
}
