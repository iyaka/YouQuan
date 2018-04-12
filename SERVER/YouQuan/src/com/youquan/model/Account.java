package com.youquan.model;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Account implements java.io.Serializable {
	private String id;
	private String account;
	private String password;
	private String name;
	private String phone;
	private Integer sex;
	private String introduction;
	private Date birthday;
	private String birthdayChar;
	private String photo;
	private Date createTime;
	private String createTimeChar;
	private Integer love;
	private Integer loved;
	private Integer type;
	private Integer status;
	private Integer offical;
	private String deviceNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthdayChar() {
		return birthdayChar;
	}

	public void setBirthdayChar(String birthdayChar) {
		this.birthdayChar = birthdayChar;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public Integer getLove() {
		return love;
	}

	public void setLove(Integer love) {
		this.love = love;
	}

	public Integer getLoved() {
		return loved;
	}

	public void setLoved(Integer loved) {
		this.loved = loved;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOffical() {
		return offical;
	}

	public void setOffical(Integer offical) {
		this.offical = offical;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Account(String id, String name, String introduction, String photo,
			String createTimeChar, Integer love, Integer loved, Integer status,
			Integer offical) {
		super();
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.photo = photo;
		this.createTimeChar = createTimeChar;
		this.love = love;
		this.loved = loved;
		this.status = status;
	}

	public Account(String id, String name, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
	}

	public Account() {
	}
}
