package com.youquan.main.model;

public class User {
	public String id; // 主键
	public String account; // 账号
	public String password; // 密码
	public String name;// 名称
	public String phone;// 手机号
	public Integer sex; // 性别
	public String introduction; // 简介
	public String birthdayChar;// 出生日期
	public String photo;// 图像
	public String createTimeChar;// 创建日期
	public Integer love;// 粉丝量
	public Integer status; // 状态（0表示正常 1表示禁用）
	public Integer offical; // 是否官方认证（0非认证 1官方认证 2超级认证）
}
