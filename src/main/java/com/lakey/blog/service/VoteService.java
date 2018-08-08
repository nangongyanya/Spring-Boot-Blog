package com.lakey.blog.service;

import com.lakey.blog.domain.Vote;

/**
 * Vote 服务接口.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
public interface VoteService {
	/**
	 * 根据id获取 Vote
	 * @param id
	 * @return
	 */
	Vote getVoteById(Long id);
	/**
	 * 删除Vote
	 * @param id
	 * @return
	 */
	void removeVote(Long id);
}
