package com.youquan.config;

public interface URL {
	String URL_LOGIN = Static.BASE_URL + "login";// 登录请求地址
	String URL_MAIN_GAMS = Static.BASE_URL + "getMainGams";// 获取主页圈子数据
	String URL_ESSAY_BY_GAM = Static.BASE_URL + "getEssayByGam";// 通过圈子获取帖子数据
	String URL_ESSAY_NEAR = Static.BASE_URL + "getNearEssay";// 通过附近帖子
	String URL_ESSAY_LOVE = Static.BASE_URL + "getLoveEssay";// 通过关注人帖子
}
