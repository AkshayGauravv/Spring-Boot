package com.springboot.virtualnugetts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.virtualnugetts.family.VirtualNuggets;
import com.springboot.virtualnugetts.repository.VirtualNuggetsRepository;
import com.springboot.virtualnugetts.service.VirtualNuggetsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest")
@Api(value = "springbootController", description = "Learning Spring Boot Microservices")
public class VirtualNugettsController {

	@Autowired
	VirtualNuggetsService virtualNuggets;

	@Autowired
	VirtualNuggetsRepository repo;

	@ApiOperation(value = "Just Returning the Virtual Nugetts", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/virtualNuggets")
	public String welcomeToVirtualNuggets() {
		return "WelcomeToVirtalNuggets";
	}

	@ApiOperation(value = "View a list of available VirtualNugetts", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/getAllVc", method = RequestMethod.GET, produces = "application/json")

	public List<VirtualNuggets> getAllVc() {
		return virtualNuggets.getAllVc();

	}

	@ApiOperation(value = "Add a VirtualNugetts")

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public void add(@RequestBody final VirtualNuggets nuggets) {
		virtualNuggets.createVc(nuggets);

	}

	// Url created like this in case of Path Variable
	// http://localhost:8300/getByUserName/gaurav
	@ApiOperation(value = "Get a VirtualNugetts by username as a path variable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/getByUserName/{username}", method = RequestMethod.GET, produces = "application/json")
	public List<VirtualNuggets> getByUserName(@PathVariable String username) {
		return virtualNuggets.getByUserName(username);

	}

	// Url created like this in case of Request Param
	// http://localhost:8300/getByUserName?username=gaurav
	@ApiOperation(value = "Get a VirtualNugetts by username as a Request Param")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/getByUserName", method = RequestMethod.GET, produces = "application/json")
	public List<VirtualNuggets> getByUserNameByRequestParam(@RequestParam String username) {
		return virtualNuggets.getByUserName(username);

	}

	@ApiOperation(value = "Update VirtualNugetts by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated VirtualNugetts"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")

	public VirtualNuggets updateById(@PathVariable Integer id, @RequestBody VirtualNuggets nugetts) {
		VirtualNuggets vnugetts = repo.getByid(id);
		vnugetts.setUserName(nugetts.getUserName());
		vnugetts.setPassword(nugetts.getPassword());

		return virtualNuggets.updateById(vnugetts);

	}

	@ApiOperation(value = "Delete VirtualNugetts by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted VirtualNugetts"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")

	public void deleteById(@PathVariable Integer id) {
		virtualNuggets.deleteById(id);
	}
}
