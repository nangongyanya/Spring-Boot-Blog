package com.lakey.blog.service;

import com.lakey.blog.domain.Authority;

/**
 * Authority 服务接口.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface AuthorityService {


	/**
	 * 根据id获取 Authority
	 *
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Long id);
}
