package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Contact;
import com.service.ContactServiceimpl;

@RestController
@RequestMapping("/contact")
public class ContatctController {
	
	
	@Autowired
	private ContactServiceimpl contactServiceimpl;
	
	@PostMapping("/save")
	public Contact save(@RequestBody Contact contact) {
		
		return contactServiceimpl.save(contact);
		
	}
	
	@GetMapping("/{id}")
	public List<Contact> getContact(@PathVariable Integer id) {
		
		return contactServiceimpl.getAll(id);
		
	}
	

}
