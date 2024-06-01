package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl impl;

	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User u) {
		User us = impl.save(u);

		return ResponseEntity.ok(us);

	}
	
	@GetMapping("/get")
	public List<User> getAll(){
		
		return impl.getAll();
	}
	
	
	@GetMapping("/get/{id}")
	public User getBy(@PathVariable Integer id){
		
		return impl.getById(id);
	}


}
