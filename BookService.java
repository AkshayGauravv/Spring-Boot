package com.springboot.virtualnugetts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.virtualnugetts.family.Book;
import com.springboot.virtualnugetts.repository.BookRepository;


@Service
public class BookService {

	@Autowired
	BookRepository bbokrepo;

	public Book publishBook(Book book) {

		// TODO Auto-generated method stub
		return bbokrepo.save(book);
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bbokrepo.findAll();
	}

}
