package com.youquan.biz;

import java.util.List;

import com.youquan.bean.JsonResult;
import com.youquan.dao.AccountDao;
import com.youquan.model.Account;

public class AccountBiz {
	private AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void findByAccountPwd(JsonResult jsonResult, String account,
			String password) {
		List<Account> users = accountDao.findByAccountPwd(account, password);
		if (users != null && users.size() > 0) {
			Account user = users.get(0);
			if (user == null) {
				jsonResult.msg = "用户不存在";
			} else {
				JsonResult.setSuccess(jsonResult, "登录成功", user);
			}
		}
	}

	// 根据ID查询圈子
	public void findById(JsonResult jsonResult, String id) {
		Account gam = accountDao.findById(id);
		JsonResult.setSuccess(jsonResult, "查询成功", gam);
	}

	// 根据用户查询圈子
	public void findMainGams(JsonResult jsonResult, String accountId) {
		List<Account> gams = accountDao.findLoveGamsByAccountId(accountId);
		JsonResult.setSuccess(jsonResult, "查询成功", gams);
	}

	// 新增/编辑 圈子
	public void saveGam(JsonResult jsonResult, String id, String name,
			String synopsis, String photo, Double lat, Double lng,
			String address, String createUserId) {
	}
}
