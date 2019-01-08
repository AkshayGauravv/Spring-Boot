package com.springboot.virtualnugetts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.virtualnugetts.family.Comments;
import com.springboot.virtualnugetts.family.Post;
import com.springboot.virtualnugetts.repository.PostReposiotry;

@Service
public class PostService {

	@Autowired
	PostReposiotry postRepo;

	public Post createPost(Post post) {
		Set<Comments> com = post.getComments();
		post.setComments(com);
		return postRepo.save(post);

		// TODO Auto-generated method stub

	}

	public List<Post> getAllPosts() {

		List<Post> post=postRepo.findAll();
		
		// TODO Auto-generated method stub
		return post;

	}

}
