package com.youquan.biz;

import com.youquan.dao.CommentDao;

public class CommentBiz {
	private CommentDao commentDao;

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
}
