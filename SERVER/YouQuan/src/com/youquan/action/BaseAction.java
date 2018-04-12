package com.youquan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	/**
	 * 获取到请求
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		return request;
	}

	/**
	 * 获取到响应
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		return response;
	}

	/**
	 * Json输出
	 * 
	 * @param response
	 */
	public void returnJson(String json) throws Exception {
		HttpServletResponse response = getResponse();
		if (response != null) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
		}
	}
}
