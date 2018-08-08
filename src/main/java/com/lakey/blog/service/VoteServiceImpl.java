package com.lakey.blog.service;

import javax.transaction.Transactional;

import com.lakey.blog.domain.Vote;
import com.lakey.blog.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Vote 服务.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;
	/* (non-Javadoc)
	 * @see VoteService#removeVote(java.lang.Long)
	 */
	@Override
	@Transactional
	public void removeVote(Long id) {
		voteRepository.deleteById(id);
	}
	@Override
	public Vote getVoteById(Long id) {
		return voteRepository.getOne(id);
	}

}
