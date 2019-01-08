package com.springboot.virtualnugetts.family;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "post")
@Data
@NamedEntityGraph(name = "postentitygrapg", 
attributeNodes = @NamedAttributeNode(value = "comments", subgraph = "commentssubgraph"), 
subgraphs = @NamedSubgraph(name = "commentssubgraph", attributeNodes = @NamedAttributeNode("commentid")))
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "content")
	private String content;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "post")
	private Set<Comments> comments = new HashSet<>();
}
