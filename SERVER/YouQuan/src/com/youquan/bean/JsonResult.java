package com.youquan.bean;

public class JsonResult {
	public int code;// 0失败 1 成功
	public String msg = "服务器错误";// 消息
	public Object data;// 数据

	public static void setSuccess(JsonResult jsonResult, String message,
			Object data) {
		if (jsonResult != null) {
			jsonResult.code = 1;
			jsonResult.msg = message;
			jsonResult.data = data;
		}
	}

	public static void setSuccess(JsonResult jsonResult, String message) {
		if (jsonResult != null) {
			jsonResult.code = 1;
			jsonResult.msg = message;
		}
	}

	public static void setFail(JsonResult jsonResult, String message) {
		if (jsonResult != null) {
			jsonResult.code = 0;
			jsonResult.msg = message;
		}
	}
}
