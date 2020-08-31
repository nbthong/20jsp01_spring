package com.thongnguyen.springhello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thongnguyen.springhello.dao.BookDAO;
import com.thongnguyen.springhello.entity.Book;

@Service
public class BookService {
	
	@Autowired
	BookDAO bookDAO;
	
	public List<Book> getBooks() {
		return bookDAO.getAllBook();
	}
	
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}
}
