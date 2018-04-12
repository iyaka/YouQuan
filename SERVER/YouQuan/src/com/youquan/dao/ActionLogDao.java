package com.youquan.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.youquan.model.ActionLog;

/**
 * A data access object (DAO) providing persistence and search support for
 * ActionLog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.youquan.model.ActionLog
 * @author MyEclipse Persistence Tools
 */
public class ActionLogDao extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ActionLogDao.class);

	protected void initDao() {
		// do nothing
	}

	public void save(ActionLog transientInstance) {
		log.debug("saving ActionLog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ActionLog persistentInstance) {
		log.debug("deleting ActionLog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActionLog findById(java.lang.String id) {
		log.debug("getting ActionLog instance with id: " + id);
		try {
			ActionLog instance = (ActionLog) getHibernateTemplate().get(
					"com.youquan.model.ActionLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ActionLog> findByExample(ActionLog instance) {
		log.debug("finding ActionLog instance by example");
		try {
			List<ActionLog> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ActionLog> findByProperty(String propertyName, Object value) {
		log.debug("finding ActionLog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ActionLog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ActionLog> findAll() {
		log.debug("finding all ActionLog instances");
		try {
			String queryString = "from ActionLog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ActionLog merge(ActionLog detachedInstance) {
		log.debug("merging ActionLog instance");
		try {
			ActionLog result = (ActionLog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ActionLog instance) {
		log.debug("attaching dirty ActionLog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActionLog instance) {
		log.debug("attaching clean ActionLog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActionLogDao getFromApplicationContext(ApplicationContext ctx) {
		return (ActionLogDao) ctx.getBean("ActionLogDAO");
	}
}