package com.springboot.virtualnugetts.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.virtualnugetts.family.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

	Family findByparents(String parents);
	
}

