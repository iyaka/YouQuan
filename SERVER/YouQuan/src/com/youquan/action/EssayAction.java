package com.youquan.action;

import javax.servlet.http.HttpServletRequest;

import com.youquan.bean.JsonResult;
import com.youquan.biz.EssayBiz;
import com.youquan.util.JsonUtils;

@SuppressWarnings("serial")
public class EssayAction extends BaseAction {
	EssayBiz essayBiz;

	public EssayBiz getEssayBiz() {
		return essayBiz;
	}

	public void setEssayBiz(EssayBiz essayBiz) {
		this.essayBiz = essayBiz;
	}

	/**
	 * 获取圈子Essay数据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getEssayByGam() throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String gamId = request.getParameter("gam_id");
				essayBiz.findEssayByGam(jsonResult, gamId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String json = JsonUtils.toJson(jsonResult);
			returnJson(json);
		}
	}

	/**
	 * 获取我关注人的帖子数据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getLoveEssay() throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String userId = request.getParameter("user_id");
				essayBiz.findLoveEssayByUserId(jsonResult, userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String json = JsonUtils.toJson(jsonResult);
			returnJson(json);
		}
	}

	/**
	 * 获取我附近的帖子数据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getNearEssay() throws Exception {
		JsonResult jsonResult = new JsonResult();
		try {
			HttpServletRequest request = getRequest();
			if (request != null) {
				String lng = request.getParameter("lng");
				String lat = request.getParameter("lat");
				essayBiz.findNearEssay(jsonResult, lng, lat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String json = JsonUtils.toJson(jsonResult);
			returnJson(json);
		}
	}
}
