package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{
	
	List<Contact> findByUserId(Integer id);

}
