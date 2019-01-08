package com.springboot.virtualnugetts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.virtualnugetts.family.Post;
import com.springboot.virtualnugetts.family.VirtualNuggets;
import com.springboot.virtualnugetts.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest")
@Api(value = "productcontroller", description = "Product Controller of Spring Boot Microservices")
public class ProductController {
	
	
	@Autowired
	PostService postSerive;
	
	@ApiOperation(value = "Just Returning the Product", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/product")
	public String product() {
		return "WelcomeToProduct";
	}
	

	@ApiOperation(value = "Add a Post")

	@RequestMapping(value = "/addpost", method = RequestMethod.POST, produces = "application/json")
	public Post add(@RequestBody final Post post) {
		return postSerive.createPost(post);

	}
	
	@ApiOperation(value = "View a list of available Post", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/getAllPost", method = RequestMethod.GET, produces = "application/json")

	public List<Post> getAllPost() {
		return postSerive.getAllPosts();

	}


}
