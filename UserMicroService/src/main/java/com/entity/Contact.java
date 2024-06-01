package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Contact {
	
	private Integer userId;
	
	private String phone;
	
	private String name;

}
