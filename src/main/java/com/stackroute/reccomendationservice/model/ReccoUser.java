package com.stackroute.reccomendationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ReccoUser {


	@Id
	private String userId;
	private List<String> reccomendations;

	// Constructors
	public ReccoUser() {
	}

	public ReccoUser(String userId, List<String> reccomendations) {
		this.userId = userId;
		this.reccomendations = reccomendations;
	}

	// Getters and setters

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getreccomendations() {
		return reccomendations;
	}

	public void setreccomendationss(List<String> reccomendations) {
		this.reccomendations = reccomendations;
	}





}
