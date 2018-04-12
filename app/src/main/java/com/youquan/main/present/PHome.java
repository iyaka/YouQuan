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
import com.youquan.main.model.Gam;
import com.youquan.main.view.VHome;

public class PHome extends Presenter {
    VHome vHome;

    public PHome(VHome vHome) {
        super();
        this.vHome = vHome;
    }

    /**
     * 获取到主页的圈子
     */
    public void reqMainGams() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("account_id", vHome.getUserId());
        HttpRequest httpRequest = new HttpRequest(URL.URL_MAIN_GAMS, httpParams, new HttpListener() {
            @Override
            public void success(String arg0) {
                MainGamResult gamResult = JsonUtils.formatJson(MainGamResult.class, arg0);
                if (checkHttp(gamResult)) {
                    vHome.setMainGams(gamResult.data);
                }
            }

            @Override
            public void failed(String arg0) {
                ToastUtils.show(arg0);
            }
        });
        Http.doPost(httpRequest);
    }

    /**
     * 获取圈子帖子
     */
    public void reqEssayByGamId() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("gam_id", vHome.getGamId());
        HttpRequest httpRequest = new HttpRequest(URL.URL_ESSAY_BY_GAM, httpParams, new HttpListener() {
            @Override
            public void success(String arg0) {
                EssayResult essayResult = JsonUtils.formatJson(EssayResult.class, arg0);
                if (checkHttp(essayResult)) {
                    vHome.setEssays(essayResult.data);
                }
            }

            @Override
            public void failed(String arg0) {
                ToastUtils.show(arg0);
            }
        });
        Http.doPost(httpRequest);
    }

    class MainGamResult extends HttpResult {
        List<Gam> data;
    }

    class EssayResult extends HttpResult {
        List<Essay> data;
    }
}
