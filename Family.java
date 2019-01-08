package com.springboot.virtualnugetts.family;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Family", catalog = "test")
@Data
public class Family implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "parents")
	private String parents;

	@Column(name = "brother")
	private String brother;

	@Column(name = "sister")
	private String sister;

	@Column(name = "niece")
	private String niece;
	
	@Column(name = "nephew")
	private String nephew;

	@Column(name = "neighbours")
	private String neighbours;
	
	@Column(name = "friends")
	private String friends;

	@Column(name = "teammates")
	private String teammates;
	

}
