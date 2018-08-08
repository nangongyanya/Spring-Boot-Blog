package com.lakey.blog.service;

import com.lakey.blog.domain.Comment;

/**
 * Comment 服务接口.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface CommentService {
	/**
	 * 根据id获取 Comment
	 * @param id
	 * @return
	 */
	Comment getCommentById(Long id);
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	void removeComment(Long id);
}
