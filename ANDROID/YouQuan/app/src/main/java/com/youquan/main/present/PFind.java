package com.youquan.main.present;

import java.util.List;

import com.http.Http;
import com.http.HttpListener;
import com.http.HttpParams;
import com.http.HttpRequest;
import com.http.HttpResult;
import com.util.JsonUtils;
import com.util.ToastUtils;
import com.youquan.config.URL;
import com.youquan.main.model.Essay;
import com.youquan.main.view.VFind;

public class PFind extends Presenter {
	VFind vFind;

	public PFind(VFind vFind) {
		super();
		this.vFind = vFind;
	}

	/**
	 * 获取附近帖子
	 */
	public void reqNearEssay() {
		HttpParams httpParams = new HttpParams();
		httpParams.put("lng", vFind.getLng());
		httpParams.put("lat", vFind.getLat());
		HttpRequest httpRequest = new HttpRequest(URL.URL_ESSAY_NEAR, httpParams, new HttpListener() {
			@Override
			public void success(String arg0) {
				EssayResult essayResult = JsonUtils.formatJson(EssayResult.class, arg0);
				if (checkHttp(essayResult)) {
					vFind.setEssays(essayResult.data);
				}
			}

			@Override
			public void failed(String arg0) {
				ToastUtils.show(arg0);
			}
		});
		Http.doPost(httpRequest);
	}

	class EssayResult extends HttpResult {
		List<Essay> data;
	}
}
