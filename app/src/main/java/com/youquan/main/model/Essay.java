package com.youquan.main.model;

import java.util.Date;

public class Essay {
	public String id; // ID
	public String content; // 内容
	public String picture; // 图片
	public String video;// 视频
	public Integer laud;// 点赞数
	public Integer comment;// 评论数
	public Integer forword;// 转发数
	public Double lng;// 经度
	public Double lat;// 纬度
	public String address;// 地址
	public String createTimeChar;// 创建时间
	public Integer transmit;// 是否转发（0 否， 1是）
	public String transmitUrl;// 转发地址
	public String userId;// 属于用户
	public String gamId;// 属于圈子
	public User user;// 用户
}
