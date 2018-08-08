package com.lakey.blog.service;

import javax.transaction.Transactional;

import com.lakey.blog.domain.Comment;
import com.lakey.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comment 服务.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	/* (non-Javadoc)
	 * @see CommentService#removeComment(java.lang.Long)
	 */
	@Override
	@Transactional
	public void removeComment(Long id) {
		commentRepository.deleteById(id);
	}
	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.getOne(id);
	}

}
