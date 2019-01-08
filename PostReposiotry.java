package com.springboot.virtualnugetts.repository;

import java.util.List;

import javax.persistence.NamedEntityGraphs;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.virtualnugetts.family.Post;

@Repository
public interface PostReposiotry extends JpaRepository<Post, Integer> {

	@EntityGraph(value = "postentitygrapg", type = EntityGraphType.FETCH)
	@Override
	public List<Post> findAll();
}
