package com.youquan.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.youquan.model.Laud;

/**
 * A data access object (DAO) providing persistence and search support for Laud
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.youquan.model.Laud
 * @author MyEclipse Persistence Tools
 */
public class LaudDao extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(LaudDao.class);

	protected void initDao() {
		// do nothing
	}

	public void saveOrUpdate(Laud transientInstance) {
		log.debug("saving Laud instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Laud persistentInstance) {
		log.debug("deleting Laud instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Laud findById(java.lang.String id) {
		log.debug("getting Laud instance with id: " + id);
		try {
			Laud instance = (Laud) getHibernateTemplate().get(
					"com.youquan.model.Laud", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Laud> findByExample(Laud instance) {
		log.debug("finding Laud instance by example");
		try {
			List<Laud> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Laud> findByProperty(String propertyName, Object value) {
		log.debug("finding Laud instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Laud as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Laud> findAll() {
		log.debug("finding all Laud instances");
		try {
			String queryString = "from Laud";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Laud merge(Laud detachedInstance) {
		log.debug("merging Laud instance");
		try {
			Laud result = (Laud) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Laud instance) {
		log.debug("attaching dirty Laud instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Laud instance) {
		log.debug("attaching clean Laud instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LaudDao getFromApplicationContext(ApplicationContext ctx) {
		return (LaudDao) ctx.getBean("LaudDAO");
	}
}