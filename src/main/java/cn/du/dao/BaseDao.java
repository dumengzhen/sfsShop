package cn.du.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T> {
	@Resource
	private HibernateTemplate hibernateTemplate;

	// 保存
	public Serializable save(T entity) {
		return hibernateTemplate.save(entity);
	}

	// 根据id获取对象
	public T get(Class<T> c, Serializable id) {
		return (T) hibernateTemplate.get(c, id);
	}

	// 根据语句获取对象
	public T get(String hql) {

		List<T> l = (List<T>) hibernateTemplate.find(hql);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	// 根据条件获取对象
	public T get(String hql, Object... values) {
		List<T> l = (List<T>) hibernateTemplate.find(hql, values);
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	// 删除对象
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	// 更新对象
	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	// 保存或修改对象
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}
	public T getByHql(String hql, Map<String, Object> params) {
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	// 查找列表所有
	public List<T> find(String hql) {
		return (List<T>) hibernateTemplate.find(hql);
	}

	// 查询符合条件的集合
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	// 根据条件分页查询出结果集合
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	// 分页显示结果
	public List<T> find(String hql, int page, int rows) {
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	// 计算总数
	public int count(String hql) {
		return find(hql).size();
	}

	// 条件查询计算总数
	public int count(String hql, Map<String, Object> params) {
		if (params.isEmpty() || params.size() == 0) {
			return count(hql);
		}
		return find(hql, params).size();
	}

	public int executeHql(String hql) {
		Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

}