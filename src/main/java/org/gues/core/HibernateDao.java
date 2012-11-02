package org.gues.core;

import java.util.List;
import java.util.Map;

public interface HibernateDao {
	
	<T> void saveOrUpdate(Class<T> clazz, Object entity);

	<T> void delete(Class<T> clazz, Object entity);

	<T> void deleteById(Class<T> clazz, int id);

	<T> T getById(Class<T> clazz, int id);

	<T> List<T> getListForPage(Class<T> clazz, final int offset, final int length, final Map<String, String> equalCondition, final Map<String, String> likeCondition);

	<T> long getListCount(Class<T> clazz, final Map<String, String> equalCondition, final Map<String, String> likeCondition);

	<T> List<T> getAll(Class<T> clazz, final Map<String, String> equalCondition, final Map<String, String> likeCondition);
}
