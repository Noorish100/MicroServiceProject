package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Contact;
import com.repository.ContactRepo;


@Service
public class ContactServiceimpl implements ContactService{
	
	
	@Autowired
	private ContactRepo contactRepo;

	@Override
	public Contact save(Contact c) {
		// TODO Auto-generated method stub
		return contactRepo.save(c);
	}

	@Override
	public List<Contact> getAll(Integer id) {
		// TODO Auto-generated method stub
		return contactRepo.findByUserId(id);
	}

}
