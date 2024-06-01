package com.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepo;
import com.service.ContactClient;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ContactClient client;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public User save(User u) {
		// TODO Auto-generated method stub
		return repo.save(u);
	}

	@Cacheable("usergetData")
	@Override
	public User getById(int id) {
		
		logger.info("In the method without cache ");
		// TODO Auto-generated method stub
		Optional<User> user= repo.findById(id);
		
	User user1= user.get();
	
	user1.setContactList(client.getContact(user1.getUserId()));
	
//	repo.save(user1);
	
	return user1;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> user=repo.findAll();
		
		List<User> updUser = user.stream()
			    .map(m -> { 
			        m.setContactList(client.getContact(m.getUserId())); 
			       
			        return m; 
			    })
			    .collect(Collectors.toList());	
		
		
		
		return  updUser;
	}

	@Override
	public String deleteUserbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
