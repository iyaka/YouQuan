package com.youquan.action;

import com.youquan.biz.CommentBiz;

@SuppressWarnings("serial")
public class CommentAction extends BaseAction {
	CommentBiz commentBiz;

	public CommentBiz getCommentBiz() {
		return commentBiz;
	}

	public void setCommentBiz(CommentBiz commentBiz) {
		this.commentBiz = commentBiz;
	}
}