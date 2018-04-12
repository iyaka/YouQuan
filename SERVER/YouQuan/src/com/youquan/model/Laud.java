package com.youquan.model;

import java.util.Date;

@SuppressWarnings("serial")
public class Laud implements java.io.Serializable {
	private String id;
	private String laudId;
	private String laudedId;
	private Date createTime;

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getLaudId() {
		return laudId;
	}

	protected void setLaudId(String laudId) {
		this.laudId = laudId;
	}

	protected String getLaudedId() {
		return laudedId;
	}

	protected void setLaudedId(String laudedId) {
		this.laudedId = laudedId;
	}

	protected Date getCreateTime() {
		return createTime;
	}

	protected void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
