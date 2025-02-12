package com.vortexify.v000.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexify.v000.payloads.ValidateRequestBody;
import com.vortexify.v000.services.DockerService;
import com.vortexify.v000.services.GitHubServices;


@RestController
@RequestMapping("/test")
public class ApplicationController {
	
	@Autowired
	private GitHubServices gitHubService;
	

	
	
	@Autowired
	private DockerService dockerService;
	
	
	
	
	@GetMapping("/")
	public ResponseEntity<Boolean> driverController(@RequestBody ValidateRequestBody requestBody){
		
		
		
		
		return new ResponseEntity<>(this.gitHubService.GetCode(requestBody.getUrl()),HttpStatus.OK);
	}

}
