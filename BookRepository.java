package com.springboot.virtualnugetts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.virtualnugetts.family.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
}