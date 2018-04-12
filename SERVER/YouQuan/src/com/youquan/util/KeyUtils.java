package com.youquan.util;

import java.util.UUID;

/**
 * Key生成器
 * 
 * @author Administrator
 * 
 */
public class KeyUtils {
	/**
	 * 获取唯一Key
	 * 
	 * @return
	 */
	public static String getUniqueKey() {
		String key = UUID.randomUUID().toString();
		key = key.toString().replaceAll("\\-", "");
		return key;
	}
}
