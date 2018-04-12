package com.youquan.main.view;

import java.util.List;

import com.youquan.main.model.Essay;

public interface VFind {
	/**
	 * 经度
	 * 
	 * @return
	 */
	String getLng();

	/**
	 * 纬度
	 * 
	 * @return
	 */
	String getLat();

	/**
	 * 设置Essay
	 * 
	 * @param datas
	 */
	void setEssays(List<Essay> datas);
}
