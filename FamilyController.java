package com.springboot.virtualnugetts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.virtualnugetts.exception.ResponseNotFoundException;
import com.springboot.virtualnugetts.family.Family;
import com.springboot.virtualnugetts.service.FamilyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest")
@Api(value = "familyController", description = "Learning Spring Boot Microservices with Family")
public class FamilyController {
	
	@Autowired
	FamilyService familyservice;
	
	@ApiOperation(value = "View a list of Famiily", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/getallfamily", method = RequestMethod.GET, produces = "application/json")

	public List<Family> getAllVc() {
		return familyservice.getAllFamily();

	}

	@ApiOperation(value = "Add a Family")

	@RequestMapping(value = "/addfamily", method = RequestMethod.POST, produces = "application/json")
	public Family add(@RequestBody final Family family) throws ResponseNotFoundException {
		return familyservice.addFamily(family);

	}

}
