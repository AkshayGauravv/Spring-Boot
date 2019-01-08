package com.springboot.virtualnugetts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.virtualnugetts.family.VirtualNuggets;


@Repository
public interface VirtualNuggetsRepository extends JpaRepository<VirtualNuggets, Integer> {
	
	List<VirtualNuggets> getVcByUserName(String userName);

	VirtualNuggets getByid(Integer id);
	
	

}
