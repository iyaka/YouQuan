package com.youquan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.youquan.model.Essay;
import com.youquan.util.ParseUtils;

/**
 * A data access object (DAO) providing persistence and search support for Essay
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.youquan.model.Essay
 * @author MyEclipse Persistence Tools
 */
public class EssayDao extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(EssayDao.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Essay transientInstance) {
		log.debug("saving Essay instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Essay persistentInstance) {
		log.debug("deleting Essay instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Essay findById(java.lang.String id) {
		log.debug("getting Essay instance with id: " + id);
		try {
			Essay instance = (Essay) getHibernateTemplate().get(
					"com.youquan.model.Essay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Essay> findByExample(Essay instance) {
		log.debug("finding Essay instance by example");
		try {
			List<Essay> results = getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Essay> findByProperty(String propertyName, Object value) {
		log.debug("finding Essay instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Essay as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Essay> findAll() {
		log.debug("finding all Essay instances");
		try {
			String queryString = "from Essay";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Essay merge(Essay detachedInstance) {
		log.debug("merging Essay instance");
		try {
			Essay result = (Essay) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Essay instance) {
		log.debug("attaching dirty Essay instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Essay instance) {
		log.debug("attaching clean Essay instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EssayDao getFromApplicationContext(ApplicationContext ctx) {
		return (EssayDao) ctx.getBean("EssayDAO");
	}

	@SuppressWarnings("unchecked")
	public List<Essay> findEssayByGamId(String gamId) {
		List<Essay> essay = new ArrayList<Essay>();
		String sql = "select id,content,picture,video,laud,comment,forword,lat,lng,address,date_format(create_time,'%Y-%m-%d %h:%i:%s') create_time,transmit,transmit_url,user_id from essay where gam_id = '"
				+ gamId + "' order by create_time desc";
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		if (list != null && list.size() > 0) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Object[] objs = list.get(i);
				essay.add(new Essay(ParseUtils.o2S(objs[0]), ParseUtils
						.o2S(objs[1]), ParseUtils.o2S(objs[2]), ParseUtils
						.o2S(objs[3]), ParseUtils.o2I(objs[4]), ParseUtils
						.o2I(objs[5]), ParseUtils.o2I(objs[6]), ParseUtils
						.o2D(objs[7]), ParseUtils.o2D(objs[8]), ParseUtils
						.o2S(objs[9]), ParseUtils.o2S(objs[10]), ParseUtils
						.o2I(objs[11]), ParseUtils.o2S(objs[12]), ParseUtils
						.o2S(objs[13])));
			}
		}
		return essay;
	}

	@SuppressWarnings("unchecked")
	public List<Essay> findNearEssay(String myLng, String myLat) {
		List<Essay> essay = new ArrayList<Essay>();
		String sql = "select id,content,picture,video,laud,comment,forword,lat,lng,address,date_format(create_time,'%Y-%m-%d %h:%i:%s') create_time,transmit,transmit_url,user_id from essay order by (ACOS(SIN("
				+ myLat
				+ " * PI() / 180) * SIN(lat * PI() / 180) + COS("
				+ myLat
				+ " * PI() / 180) * COS(lat * PI() / 180) * COS("
				+ myLng
				+ " * PI() / 180 - lng * PI() / 180)) * 6378.14) asc limit 30";
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		if (list != null && list.size() > 0) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Object[] objs = list.get(i);
				essay.add(new Essay(ParseUtils.o2S(objs[0]), ParseUtils
						.o2S(objs[1]), ParseUtils.o2S(objs[2]), ParseUtils
						.o2S(objs[3]), ParseUtils.o2I(objs[4]), ParseUtils
						.o2I(objs[5]), ParseUtils.o2I(objs[6]), ParseUtils
						.o2D(objs[7]), ParseUtils.o2D(objs[8]), ParseUtils
						.o2S(objs[9]), ParseUtils.o2S(objs[10]), ParseUtils
						.o2I(objs[11]), ParseUtils.o2S(objs[12]), ParseUtils
						.o2S(objs[13])));
			}
		}
		return essay;
	}

	@SuppressWarnings("unchecked")
	public List<Essay> findLoveEssayByUserId(String userId) {
		List<Essay> essay = new ArrayList<Essay>();
		String sql = "select ey.id,ey.content,ey.picture,ey.video,ey.laud,ey.comment,ey.forword,ey.lat,ey.lng,ey.address,date_format(ey.create_time,'%Y-%m-%d %h:%i:%s') create_time,ey.transmit,ey.transmit_url,ey.user_id from love l inner join essay ey on l.loved_id = ey.user_id inner join account acc on l.loved_id = acc.id where l.love_id = '"
				+ userId + "' and acc.type = 0 order by ey.create_time desc";
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		if (list != null && list.size() > 0) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Object[] objs = list.get(i);
				essay.add(new Essay(ParseUtils.o2S(objs[0]), ParseUtils
						.o2S(objs[1]), ParseUtils.o2S(objs[2]), ParseUtils
						.o2S(objs[3]), ParseUtils.o2I(objs[4]), ParseUtils
						.o2I(objs[5]), ParseUtils.o2I(objs[6]), ParseUtils
						.o2D(objs[7]), ParseUtils.o2D(objs[8]), ParseUtils
						.o2S(objs[9]), ParseUtils.o2S(objs[10]), ParseUtils
						.o2I(objs[11]), ParseUtils.o2S(objs[12]), ParseUtils
						.o2S(objs[13])));
			}
		}
		return essay;
	}
}