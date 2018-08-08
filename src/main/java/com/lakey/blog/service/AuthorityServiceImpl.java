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
 * @since 1.0.0 2017年3月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Long id) {
		return authorityRepository.findOne(id);
	}

}
