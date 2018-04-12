package com.youquan.model;

import java.util.Date;

@SuppressWarnings("serial")
public class ActionLog implements java.io.Serializable {
	private String id;
	private String useId;
	private String usedId;
	private String actionId;
	private Date createTime;

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getUseId() {
		return useId;
	}

	protected void setUseId(String useId) {
		this.useId = useId;
	}

	protected String getUsedId() {
		return usedId;
	}

	protected void setUsedId(String usedId) {
		this.usedId = usedId;
	}

	protected String getActionId() {
		return actionId;
	}

	protected void setActionId(String actionId) {
		this.actionId = actionId;
	}

	protected Date getCreateTime() {
		return createTime;
	}

	protected void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
