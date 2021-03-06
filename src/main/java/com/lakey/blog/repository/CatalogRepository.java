package com.lakey.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakey.blog.domain.Catalog;
import com.lakey.blog.domain.User;

/**
 * Catalog 仓库
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long>{
	
	/**
	 * 根据用户查询
	 * @param user
	 * @return
	 */
	List<Catalog> findByUser(User user);
	
	/**
	 * 根据用户查询
	 * @param user
	 * @param name
	 * @return
	 */
	List<Catalog> findByUserAndName(User user,String name);
}
