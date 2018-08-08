package com.lakey.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lakey.blog.domain.Blog;
import com.lakey.blog.domain.Catalog;
import com.lakey.blog.domain.User;

/**
 * Blog 仓库
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface BlogRepository extends JpaRepository<Blog, Long>{
	/**
	 * 根据用户名分页查询用户列表（最新）
	 * 由 findByUserAndTitleLikeOrTagsLikeOrderByCreateTimeDesc 代替，可以根据标签进行查询
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
	@Deprecated
	Page<Blog> findByUserAndTitleLikeOrderByCreateTimeDesc(User user, String title, Pageable pageable);

	/**
	 * 根据用户名分页查询用户列表
	 *
	 * @param user
	 * @param title
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);

    /**
     * 根据用户名分页查询用户列表
     *
     * @param title
     * @param user
     * @param tags
     * @param user2
     * @param pageable
     * @return
     */
	Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,String tags,User user2,Pageable pageable);

    /**
     * 根据用户名分页查询用户列表
     *
     * @param catalog
     * @param pageable
     * @return
     */
	Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);
}
