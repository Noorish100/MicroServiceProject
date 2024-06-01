package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	
	User save (User u);
	
	User getById (int id);
	
	List<User> getAll ();
	
	String deleteUserbyId(int id);
	
	String updateUser (User u);

}
