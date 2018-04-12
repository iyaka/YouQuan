package com.youquan.main.view;

import java.util.List;

import com.youquan.main.model.Essay;

public interface VQuan {
    /**
     * 获取用户ID
     *
     * @return
     */
    String getUserId();

    /**
     * 设置Essay
     *
     * @param datas
     */
    void setEssays(List<Essay> datas);
}
