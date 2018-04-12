package com.youquan.biz;

import java.util.List;

import com.youquan.bean.JsonResult;
import com.youquan.dao.AccountDao;
import com.youquan.dao.EssayDao;
import com.youquan.model.Account;
import com.youquan.model.Essay;
import com.youquan.util.StringUtils;

public class EssayBiz {
	private EssayDao essayDao;
	private AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public EssayDao getEssayDao() {
		return essayDao;
	}

	public void setEssayDao(EssayDao essayDao) {
		this.essayDao = essayDao;
	}

	// 通过圈组查询帖子
	public void findEssayByGam(JsonResult jsonResult, String gamId) {
		List<Essay> essay = essayDao.findEssayByGamId(gamId);
		int size = essay.size();
		for (int i = 0; i < size; i++) {
			Essay e = essay.get(i);
			if (e != null && !StringUtils.isEmptyString(e.getUserId())) {
				Account user = accountDao.findSimpleUserById(e.getUserId());
				e.setUser(user);
			}
		}
		JsonResult.setSuccess(jsonResult, "查询成功", essay);
	}

	// 通过我关注查询关注人的帖子
	public void findLoveEssayByUserId(JsonResult jsonResult, String userId) {
		List<Essay> essay = essayDao.findLoveEssayByUserId(userId);
		int size = essay.size();
		for (int i = 0; i < size; i++) {
			Essay e = essay.get(i);
			if (e != null && !StringUtils.isEmptyString(e.getUserId())) {
				Account user = accountDao.findSimpleUserById(e.getUserId());
				e.setUser(user);
			}
		}
		JsonResult.setSuccess(jsonResult, "查询成功", essay);
	}

	// 通过附近帖子
	public void findNearEssay(JsonResult jsonResult, String myLng, String myLat) {
		List<Essay> essay = essayDao.findNearEssay(myLng, myLat);
		int size = essay.size();
		for (int i = 0; i < size; i++) {
			Essay e = essay.get(i);
			if (e != null && !StringUtils.isEmptyString(e.getUserId())) {
				Account user = accountDao.findSimpleUserById(e.getUserId());
				e.setUser(user);
			}
		}
		JsonResult.setSuccess(jsonResult, "查询成功", essay);
	}
}
