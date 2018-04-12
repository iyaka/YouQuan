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
import com.youquan.main.view.VQuan;

public class PQuan extends Presenter {
	VQuan vQuan;

	public PQuan(VQuan vQuan) {
		super();
		this.vQuan = vQuan;
	}

	/**
	 * 获取我关注人的帖子
	 */
	public void reqLoveEssay() {
		HttpParams httpParams = new HttpParams();
		httpParams.put("user_id", vQuan.getUserId());
		HttpRequest httpRequest = new HttpRequest(URL.URL_ESSAY_LOVE, httpParams, new HttpListener() {
			@Override
			public void success(String arg0) {
				EssayResult essayResult = JsonUtils.formatJson(EssayResult.class, arg0);
				if (checkHttp(essayResult)) {
					vQuan.setEssays(essayResult.data);
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
