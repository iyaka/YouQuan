package com.youquan.main.present;

import com.http.HttpResult;
import com.youquan.MyApp;

public class Presenter {
	/**
	 * HTTP 请求
	 * 
	 * @param httpResult
	 * @return
	 */
	protected boolean checkHttp(HttpResult httpResult) {
		return httpResult != null && httpResult.code == MyApp.config.getHttpSuccessCode();
	}
}
