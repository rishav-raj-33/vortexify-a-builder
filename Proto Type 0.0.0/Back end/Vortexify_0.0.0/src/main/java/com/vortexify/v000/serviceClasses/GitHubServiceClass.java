package com.vortexify.v000.serviceClasses;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vortexify.v000.services.GitHubServices;



@Service
public class GitHubServiceClass implements GitHubServices  {
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	@Override
	public boolean isPublic(String url) {
		
		
		
		ResponseEntity<String> response;
		
		
		try {
			response = restTemplate.getForEntity(url, String.class);
			
		} catch(Exception e) {
			System.out.print(e);
			return false;
			
		}

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            if (responseBody != null && responseBody.contains("\"private\":true")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
	}

	@Override
	public boolean GetCode(String url) {
		
		String projectName=extractProjectName(url);
		
		if(projectName==null) return false;
		
		  File cloneDirectory = new File("clone/"+projectName);

	        try {
	            
	            Git.cloneRepository()
	                .setURI(url)   
	                .setDirectory(cloneDirectory) 
	                .call();

                 return true;
	        } catch (GitAPIException  e) {
	            e.printStackTrace();
	        }
		return false;
	}
	
	
	
	 private static String extractProjectName(String gitHubUrl) {
	        if (gitHubUrl.endsWith(".git")) {
	            gitHubUrl = gitHubUrl.substring(0, gitHubUrl.length() - 4);
	        }
	        
	        
	        String regex = ".*/([^/]+)$"; 
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(gitHubUrl);
	        
	        if (matcher.find()) {
	            return matcher.group(1); 
	        } else {
	            return null; 
	        }
	    }
	
	
	
	

}
