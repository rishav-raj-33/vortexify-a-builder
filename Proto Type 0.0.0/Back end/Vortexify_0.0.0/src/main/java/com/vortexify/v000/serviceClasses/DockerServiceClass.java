package com.vortexify.v000.serviceClasses;

import org.springframework.stereotype.Service;

import com.vortexify.v000.services.DockerService;


@Service
public class DockerServiceClass implements DockerService {

	@Override
	public String buildImage(String path) {
		return null;
	}

	@Override
	public String runImage(String path) {
		return null;
	}

}
