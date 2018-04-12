package com.youquan.model;

import java.util.Date;

/**
 * Essay entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Essay implements java.io.Serializable {
	private String id;
	private String content;
	private String picture;
	private String video;
	private Integer laud;
	private Integer comment;
	private Integer forword;
	private Double lng;
	private Double lat;
	private String address;
	private Date createTime;
	private String createTimeChar;
	private Integer transmit;
	private String transmitUrl;
	private String userId;
	private String gamId;
	private Account user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Integer getLaud() {
		return laud;
	}

	public void setLaud(Integer laud) {
		this.laud = laud;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Integer getForword() {
		return forword;
	}

	public void setForword(Integer forword) {
		this.forword = forword;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeChar() {
		return createTimeChar;
	}

	public void setCreateTimeChar(String createTimeChar) {
		this.createTimeChar = createTimeChar;
	}

	public Integer getTransmit() {
		return transmit;
	}

	public void setTransmit(Integer transmit) {
		this.transmit = transmit;
	}

	public String getTransmitUrl() {
		return transmitUrl;
	}

	public void setTransmitUrl(String transmitUrl) {
		this.transmitUrl = transmitUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGamId() {
		return gamId;
	}

	public void setGamId(String gamId) {
		this.gamId = gamId;
	}

	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}

	public Essay(String id, String content, String picture, String video,
			Integer laud, Integer comment, Integer forword, Double lat,
			Double lng, String address, String createTimeChar,
			Integer transmit, String transmitUrl, String userId) {
		super();
		this.id = id;
		this.content = content;
		this.picture = picture;
		this.video = video;
		this.laud = laud;
		this.comment = comment;
		this.forword = forword;
		this.lat = lat;
		this.lng = lng;
		this.address = address;
		this.createTimeChar = createTimeChar;
		this.transmit = transmit;
		this.transmitUrl = transmitUrl;
		this.userId = userId;
	}

}
