package com.stackroute.reccomendationservice.controller;

import com.stackroute.reccomendationservice.model.*;
import com.stackroute.reccomendationservice.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/reccomendations")
public class ReccomendationUserController {
	   @Autowired
	    private ReccoUserService ReccoUserService;

	    public ReccomendationUserController() {

	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<?> getAllGifs(@PathVariable String userId){
	        try{
	            List<String> reccoList = ReccoUserService.userReccomendations(userId);
	            return new ResponseEntity<>(reccoList,HttpStatus.OK);
	        }catch(Exception e){
	            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	        }

	    }

	    @PostMapping
	    public ResponseEntity<?> addGifs(@RequestBody ReccoUser body){
	        boolean added = ReccoUserService.addReccomendation(body);
	        System.out.println(added);
	        if(added){
	            return new ResponseEntity<>(body,HttpStatus.CREATED);

	        }
	        else{
	            return new ResponseEntity<>("Not added",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	

}
