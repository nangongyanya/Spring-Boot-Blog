package com.lakey.blog.repository;

import java.util.Collection;
import java.util.List;

import com.lakey.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User 仓库
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 根据用户名分页查询用户列表
     *
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<User> findByNameLike(String name, Pageable pageable);
	/**
	 * 根据名称查询
     *
	 * @param username
	 * @return
	 */
	User findByUsername(String username);
	/**
	 * 根据名称列表查询
     *
	 * @param usernames
	 * @return
	 */
	List<User> findByUsernameIn(Collection<String> usernames);
}
