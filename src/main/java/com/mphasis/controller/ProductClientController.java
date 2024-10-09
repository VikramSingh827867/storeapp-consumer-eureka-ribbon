package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Book;

@RestController
@Scope("request")
public class ProductClientController {
	
	@Autowired
	private RestTemplate restemplate;
	
	@GetMapping("/get-books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		
		Book book = restemplate.getForObject("http://book-service/books/" + id, Book.class);
		
		return book;
	}

}
