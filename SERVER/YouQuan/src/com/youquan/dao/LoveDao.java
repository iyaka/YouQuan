package com.youquan.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.youquan.model.Love;

/**
 * A data access object (DAO) providing persistence and search support for Love
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.youquan.model.Love
 * @author MyEclipse Persistence Tools
 */
public class LoveDao extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(LoveDao.class);

	protected void initDao() {
		// do nothing
	}

	public void saveOrUpdate(Love transientInstance) {
		log.debug("saving Love instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Love persistentInstance) {
		log.debug("deleting Love instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Love findById(java.lang.String id) {
		log.debug("getting Love instance with id: " + id);
		try {
			Love instance = (Love) getHibernateTemplate().get(
					"com.youquan.model.Love", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Love> findByExample(Love instance) {
		log.debug("finding Love instance by example");
		try {
			List<Love> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Love> findByProperty(String propertyName, Object value) {
		log.debug("finding Love instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Love as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Love> findAll() {
		log.debug("finding all Love instances");
		try {
			String queryString = "from Love";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Love merge(Love detachedInstance) {
		log.debug("merging Love instance");
		try {
			Love result = (Love) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Love instance) {
		log.debug("attaching dirty Love instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Love instance) {
		log.debug("attaching clean Love instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LoveDao getFromApplicationContext(ApplicationContext ctx) {
		return (LoveDao) ctx.getBean("LoveDAO");
	}
}