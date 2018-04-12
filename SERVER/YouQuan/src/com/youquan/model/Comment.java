package com.youquan.model;

import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class Comment implements java.io.Serializable {
	private String id;
	private String content;
	private Date createTime;
	private Integer laud;
	private String essayId;
	private String commentId;

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	protected Date getCreateTime() {
		return createTime;
	}

	protected void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLaud() {
		return laud;
	}

	public void setLaud(Integer laud) {
		this.laud = laud;
	}

	protected String getEssayId() {
		return essayId;
	}

	protected void setEssayId(String essayId) {
		this.essayId = essayId;
	}

	protected String getCommentId() {
		return commentId;
	}

	protected void setCommentId(String commentId) {
		this.commentId = commentId;
	}

}
