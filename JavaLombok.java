package com.springboot.virtualnugetts.lombook;

import java.io.Serializable;

import lombok.Data;


@Data
public class JavaLombok implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	String first_name;
	String last_name;
	String email_id;
	String website;
	
	

}
