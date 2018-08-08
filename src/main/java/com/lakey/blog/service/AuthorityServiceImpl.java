/**
 * 
 */
package com.lakey.blog.service;

import com.lakey.blog.domain.Authority;
import com.lakey.blog.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Authority 服务.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Long id) {
		return authorityRepository.getOne(id);
	}

}
