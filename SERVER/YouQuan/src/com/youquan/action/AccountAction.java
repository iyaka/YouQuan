package com.youquan.action;

import javax.servlet.http.HttpServletRequest;

import com.youquan.bean.JsonResult;
import com.youquan.biz.AccountBiz;
import com.youquan.util.JsonUtils;

@SuppressWarnings("serial")
public class AccountAction extends BaseAction {
	AccountBiz accountBiz;

	public AccountBiz getAccountBiz() {
		return accountBiz;
	}

	public void setAccountBiz(AccountBiz accountBiz) {
		this.accountBiz = accountBiz;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void doLogin() throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String account = request.getParameter("account");
				String password = request.getParameter("password");
				accountBiz.findByAccountPwd(jsonResult, account, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String json = JsonUtils.toJson(jsonResult);
			returnJson(json);
		}
	}

	/**
	 * 获取Gam数据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getMainGams() throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String accountId = request.getParameter("account_id");
				accountBiz.findMainGams(jsonResult, accountId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String json = JsonUtils.toJson(jsonResult);
			returnJson(json);
		}
	}

	/**
	 * SaveGam数据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveGam() throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String synopsis = request.getParameter("synopsis");
				String photo = request.getParameter("photo");
				double lat = Double.parseDouble(request.getParameter("lat"));
				double lng = Double.parseDouble(request.getParameter("lng"));
				String address = request.getParameter("address");
				String createUserId = request.getParameter("create_user_id");
				accountBiz.saveGam(jsonResult, id, name, synopsis, photo, lat,
						lng, address, createUserId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String json = JsonUtils.toJson(jsonResult);
			returnJson(json);
		}
	}
}
