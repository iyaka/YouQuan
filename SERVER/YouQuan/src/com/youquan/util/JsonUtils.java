package com.youquan.util;

import com.google.gson.Gson;

/**
 * JSON数据 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class JsonUtils {
	/**
	 * Format Json
	 * 
	 * @param classOfT
	 * @param json
	 * @return
	 */
	public static <T> T formatJson(Class<T> classOfT, String json) {
		T res = null;
		try {
			if (!StringUtils.isEmptyString(json)) {
				json = json.replace("null", "\"\"");
			}
			res = StringUtils.isEmptyString(json) ? null : new Gson().fromJson(json, classOfT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * To Json
	 * 
	 * @param classOfT
	 * @param json
	 * @return
	 */
	public static String toJson(Object src) {
		return new Gson().toJson(src);
	}
}
