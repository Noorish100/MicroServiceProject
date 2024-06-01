package com.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.Contact;

//@FeignClient(url="http://localhost:8881" ,value="contact-client")
@FeignClient(name="CONTACT-MICROSERVICE")
public interface ContactClient {
	
	
	@GetMapping("/contact/{id}")
	List<Contact> getContact(@PathVariable Integer id); 

}
