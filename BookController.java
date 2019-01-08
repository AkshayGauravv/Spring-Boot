package com.springboot.virtualnugetts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.virtualnugetts.family.Book;
import com.springboot.virtualnugetts.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest")
@Api(value = "bookController", description = "Book Controller of Spring Boot Microservices")
public class BookController {

		
		@Autowired
		BookService bookSerive;
		
		@ApiOperation(value = "Just Returning the Book", response = Iterable.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

		@RequestMapping(value = "/book")
		public String product() {
			return "WelcomeToLibrary";
		}
		

		@ApiOperation(value = "Add a Book")

		@RequestMapping(value = "/addbook", method = RequestMethod.POST, produces = "application/json")
		public Book add(@RequestBody final Book book) {
			return bookSerive.publishBook(book);

		}
		
		@ApiOperation(value = "View a list of available Books", response = Iterable.class)
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
				@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
				@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

		@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET, produces = "application/json")

		public List<Book> getAllPost() {
			return bookSerive.getAllBooks();

		}


}
