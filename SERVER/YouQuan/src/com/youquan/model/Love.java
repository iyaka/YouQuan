package com.youquan.model;

import java.util.Date;

@SuppressWarnings("serial")
public class Love implements java.io.Serializable {
	private String id;
	private String loveId;
	private String lovedId;
	private Date createTime;

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getLoveId() {
		return loveId;
	}

	protected void setLoveId(String loveId) {
		this.loveId = loveId;
	}

	protected String getLovedId() {
		return lovedId;
	}

	protected void setLovedId(String lovedId) {
		this.lovedId = lovedId;
	}

	protected Date getCreateTime() {
		return createTime;
	}

	protected void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
