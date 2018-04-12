package com.youquan.util;

public class ParseUtils {

	/**
	 * String转Integer
	 * 
	 * @param string
	 * @return
	 */
	public static Integer s2I(String string) {
		try {
			if (StringUtils.isEmptyString(string)) {
				return 0;
			}
			return Integer.parseInt(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * String转Double
	 * 
	 * @param string
	 * @return
	 */
	public static Double s2D(String string) {
		try {
			if (StringUtils.isEmptyString(string)) {
				return 0d;
			}
			return Double.parseDouble(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0d;
	}

	/**
	 * Object转Integer
	 * 
	 * @param string
	 * @return
	 */
	public static Integer o2I(Object obj) {
		try {
			if (obj == null) {
				return 0;
			} else {
				return s2I(obj.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Object转Double
	 * 
	 * @param string
	 * @return
	 */
	public static Double o2D(Object obj) {
		try {
			if (obj == null) {
				return 0d;
			} else {
				return s2D(obj.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0d;
	}

	/**
	 * Object转Integer
	 * 
	 * @param string
	 * @return
	 */
	public static String o2S(Object obj) {
		try {
			if (obj == null) {
				return null;
			} else {
				return obj.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
