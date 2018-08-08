package com.lakey.blog.service;

import javax.transaction.Transactional;

import com.lakey.blog.domain.Blog;
import com.lakey.blog.domain.Catalog;
import com.lakey.blog.domain.Vote;
import com.lakey.blog.domain.es.EsBlog;
import com.lakey.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lakey.blog.domain.Comment;
import com.lakey.blog.domain.User;

/**
 * Blog 服务
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private EsBlogService esBlogService;
 
	/* (non-Javadoc)
	 * @see BlogService#saveBlog(Blog)
	 */
	@Transactional
	@Override
	public Blog saveBlog(Blog blog) {
		boolean isNew = (blog.getId() == null);
		EsBlog esBlog = null;
		
		Blog returnBlog = blogRepository.save(blog);
		
		if (isNew) {
			esBlog = new EsBlog(returnBlog);
		} else {
			esBlog = esBlogService.getEsBlogByBlogId(blog.getId());
			esBlog.update(returnBlog);
		}
		
		esBlogService.updateEsBlog(esBlog);
		return returnBlog;
	}

	/* (non-Javadoc)
	 * @see BlogService#removeBlog(java.lang.Long)
	 */
	@Transactional
	@Override
	public void removeBlog(Long id) {
		blogRepository.deleteById(id);
		EsBlog esblog = esBlogService.getEsBlogByBlogId(id);
		esBlogService.removeEsBlog(esblog.getId());
	}

	/* (non-Javadoc)
	 * @see BlogService#getBlogById(java.lang.Long)
	 */
	@Override
	public Blog getBlogById(Long id) {
		return blogRepository.getOne(id);
	}

	@Override
	public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
		// 模糊查询
		title = "%" + title + "%";
		//Page<Blog> blogs = blogRepository.findByUserAndTitleLikeOrderByCreateTimeDesc(user, title, pageable);
		String tags = title;
		Page<Blog> blogs = blogRepository.findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(title,user, tags,user, pageable);
		return blogs;
	}

	@Override
	public Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable) {
		// 模糊查询
		title = "%" + title + "%";
		Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, title, pageable);
		return blogs;
	}
	
	@Override
	public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
		Page<Blog> blogs = blogRepository.findByCatalog(catalog, pageable);
		return blogs;
	}

	@Override
	public void readingIncrease(Long id) {
		Blog blog = blogRepository.getOne(id);
		blog.setReadSize(blog.getCommentSize()+1);
		this.saveBlog(blog);
	}

	@Override
	public Blog createComment(Long blogId, String commentContent) {
		Blog originalBlog = blogRepository.getOne(blogId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Comment comment = new Comment(user, commentContent);
		originalBlog.addComment(comment);
		return this.saveBlog(originalBlog);
	}

	@Override
	public void removeComment(Long blogId, Long commentId) {
		Blog originalBlog = blogRepository.getOne(blogId);
		originalBlog.removeComment(commentId);
		this.saveBlog(originalBlog);
	}

	@Override
	public Blog createVote(Long blogId) {
		Blog originalBlog = blogRepository.getOne(blogId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		Vote vote = new Vote(user);
		boolean isExist = originalBlog.addVote(vote);
		if (isExist) {
			throw new IllegalArgumentException("该用户已经点过赞了");
		}
		return this.saveBlog(originalBlog);
	}

	@Override
	public void removeVote(Long blogId, Long voteId) {
		Blog originalBlog = blogRepository.getOne(blogId);
		originalBlog.removeVote(voteId);
		this.saveBlog(originalBlog);
	}
}
