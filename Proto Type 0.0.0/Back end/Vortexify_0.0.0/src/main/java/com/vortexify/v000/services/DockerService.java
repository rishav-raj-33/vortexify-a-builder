package com.vortexify.v000.services;

public interface DockerService {
	
	
	public String buildImage(String path);
	public String runImage(String path);
	

}
