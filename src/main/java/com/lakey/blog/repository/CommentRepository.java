package com.lakey.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakey.blog.domain.Comment;

/**
 * Comment 仓库
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{
 
}
