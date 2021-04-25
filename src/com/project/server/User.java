package com.project.server;

import java.io.PrintWriter;

public class User {

	private PrintWriter nos;
	private String username;
	
	public User(PrintWriter nos, String username){
		this.nos = nos;
		this.username = username;
	}
	
	public PrintWriter getNos() {
		return nos;
	}
	
	public String getUsername() {
		return username;
	}
	
	
	
}
