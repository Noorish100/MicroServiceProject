package com.service;

import java.util.List;

import com.entity.Contact;

public interface ContactService {
	
	Contact save(Contact c);
	
	List<Contact> getAll(Integer id);

}
