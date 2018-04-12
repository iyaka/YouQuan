package com.youquan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.youquan.model.Account;
import com.youquan.util.ParseUtils;
import com.youquan.util.StringUtils;

/**
 * A data access object (DAO) providing persistence and search support for
 * Account entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle Account-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.youquan.model.Account
 * @author MyEclipse Persistence Tools
 */
public class AccountDao extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AccountDao.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Account transientInstance) {
		log.debug("saving Account instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Account persistentInstance) {
		log.debug("deleting Account instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Account findById(java.lang.String id) {
		log.debug("getting Account instance with id: " + id);
		try {
			Account instance = (Account) getHibernateTemplate().get(
					"com.youquan.model.Account", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Account> findByExample(Account instance) {
		log.debug("finding Account instance by example");
		try {
			List<Account> results = getHibernateTemplate().findByExample(
					instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Account> findByProperty(String propertyName, Object value) {
		log.debug("finding Account instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Account as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		log.debug("finding all Account instances");
		try {
			String queryString = "from Account";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Account merge(Account detachedInstance) {
		log.debug("merging Account instance");
		try {
			Account result = (Account) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Account instance) {
		log.debug("attaching dirty Account instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Account instance) {
		log.debug("attaching clean Account instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AccountDao getFromApplicationContext(ApplicationContext ctx) {
		return (AccountDao) ctx.getBean("AccountDAO");
	}

	@SuppressWarnings("unchecked")
	public List<Account> findByAccountPwd(String account, String password) {
		String sql = "select * from account where account = '" + account
				+ "' and password = '" + password + "'";
		return getSession().createSQLQuery(sql).addEntity(Account.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Account> findLoveGamsByAccountId(String accountId) {
		List<Account> gams = new ArrayList<Account>();
		String sql = "";
		if (StringUtils.isEmptyString(accountId)) {
			sql = "select a.id,a.name,a.introduction,a.photo,date_format(a.create_time,'%Y-%m-%d %h:%i:%s') create_time,a.love,a.loved,a.status,a.offical from account a where a.type = 1 and a.offical = 1 and a.status = 0";
		} else {
			sql = "select a.id,a.name,a.introduction,a.photo,date_format(a.create_time,'%Y-%m-%d %h:%i:%s') create_time,a.love,a.loved,a.status,a.offical from love l inner join account a on l.loved_id = a.id where a.type = 1 and l.love_id = '"
					+ accountId + "'";
		}
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		if (list != null && list.size() > 0) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Object[] objs = list.get(i);
				gams.add(new Account(ParseUtils.o2S(objs[0]), ParseUtils
						.o2S(objs[1]), ParseUtils.o2S(objs[2]), ParseUtils
						.o2S(objs[3]), ParseUtils.o2S(objs[4]), ParseUtils
						.o2I(objs[5]), ParseUtils.o2I(objs[6]), ParseUtils
						.o2I(objs[7]), ParseUtils.o2I(objs[8])));
			}
		}
		return gams;
	}

	@SuppressWarnings("unchecked")
	public Account findSimpleUserById(String accountId) {
		Account gam = null;
		String sql = "select id,name,photo from account where id = "
				+ accountId;
		List<Object[]> list = getSession().createSQLQuery(sql).list();
		if (list != null && list.size() > 0) {
			Object[] objs = list.get(0);
			gam = new Account(ParseUtils.o2S(objs[0]), ParseUtils.o2S(objs[1]),
					ParseUtils.o2S(objs[2]));
		}
		return gam;
	}
}