package com.youquan.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class StringUtils {
	/**
	 * 判断字符串为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmptyString(String string) {
		return null == string || string.trim().length() == 0;
	}

	/**
	 * 检验字符串是否是合法邮箱地址
	 * 
	 * @param emailString
	 * @return
	 */
	public static boolean checkEmailString(String emailString) {
		if (isEmptyString(emailString)) {
			return false;
		}
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(emailString);
		return m.matches();
	}

	/**
	 * 检验字符串是否是合法手机号
	 * 
	 * @param phoneString
	 * @return
	 */
	public static boolean checkPhoneString(String phoneString) {
		if (isEmptyString(phoneString)) {
			return false;
		}
		String regExp = "1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phoneString);
		return m.matches();
	}

	/**
	 * 保留两位小数
	 * 
	 * @param doubleString
	 * @return
	 */
	public static double retainString(double doubleString) {
		double result = 0;
		try {
			DecimalFormat df = new DecimalFormat("######0.00");
			result = Double.parseDouble(df.format(doubleString));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 检验字符串是否为空，并把null字符串转换成空字符串
	 * 
	 * @param string
	 * @return
	 */
	public static String reviseEmpty(String string) {
		return isEmptyString(string) ? "" : string;
	}

	/**
	 * 检验字符串是否为空，并把null字符串转换成给出的默认字符串
	 * 
	 * @param string
	 * @return
	 */
	public static String reviseEmpty(String string, String defaultString) {
		return isEmptyString(string) ? defaultString : string;
	}

	/**
	 * 获取百分比字符串
	 * 
	 * @param num
	 * @param total
	 * @return
	 */
	public static String getPercentString(int num, int total) {
		// 总数为0不用计算
		String result = "0%";
		if (total > 0) {
			try {
				double num_double = num * 1.0;
				double result_temp = num_double / total;
				// format percent
				DecimalFormat df = new DecimalFormat("0.00%");
				result = df.format(result_temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获取百分比字符串
	 * 
	 * @param num
	 * @param total
	 * @return
	 */
	public static String getPercentString(long num, long total) {
		// 总数为0不用计算
		String result = "0%";
		if (total > 0) {
			try {
				double num_double = num * 1.0;
				double result_temp = num_double / total;
				// format percent
				DecimalFormat df = new DecimalFormat("0.00%");
				result = df.format(result_temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获取百分比字符串
	 * 
	 * @param num
	 * @param total
	 * @return
	 */
	public static String getPercentString(double num, double total) {
		// 总数为0不用计算
		String result = "0%";
		if (total > 0) {
			try {
				double result_temp = num / total;
				// format percent
				DecimalFormat df = new DecimalFormat("0.00%");
				result = df.format(result_temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 切割字符串(不抛异常版)
	 * 
	 * @param string
	 * @param charString
	 * @return
	 */
	public static String[] spiltString(String string, String charString) {
		String[] spiltString = null;
		if (!isEmptyString(string)) {
			try {
				spiltString = string.split(charString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return spiltString;
	}

}
