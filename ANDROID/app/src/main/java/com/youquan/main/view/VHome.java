package com.youquan.main.view;

import java.util.List;

import com.youquan.main.model.Essay;
import com.youquan.main.model.Gam;

public interface VHome {
    /**
     * 获取用户ID
     *
     * @return
     */
    String getUserId();

    /**
     * 获取圈子ID
     *
     * @return
     */
    String getGamId();

    /**
     * 设置主页的GAM
     *
     * @param datas
     */
    void setMainGams(List<Gam> datas);

    /**
     * 设置Essay
     *
     * @param datas
     */
    void setEssays(List<Essay> datas);
}
