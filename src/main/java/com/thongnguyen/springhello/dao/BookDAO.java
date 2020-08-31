package com.thongnguyen.springhello.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thongnguyen.springhello.entity.Book;


@Repository
@Transactional
public class BookDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}
	
	
	public List<Book> getAllBook(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
		return criteria.list();
	}
	
}
