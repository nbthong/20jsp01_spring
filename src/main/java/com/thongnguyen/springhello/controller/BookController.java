package com.thongnguyen.springhello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thongnguyen.springhello.entity.Book;
import com.thongnguyen.springhello.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("administration");
		
		List<Book> bookList = bookService.getBooks();
		mav.addObject("books", bookList);
		
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "insertBook";
	}
			
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam(value="name") String name,
							  @RequestParam(value="author") String author,
							  @RequestParam(value="publisher") String publisher,
							  @RequestParam(value="type") String type,
							  @RequestParam(value="language") String language,
							  @RequestParam(value="description") String description,
							  @RequestParam(value="quantity") int quantity){
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setType(type);
		book.setLanguage(language);
		book.setDescription(description);
		book.setQuantity(quantity);
		
		bookService.addBook(book);
		
		return "redirect:getall";
	}
	
	
	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public ModelAndView addForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("insertBookSpringForm");
		
		Book book = new Book();
		mav.addObject("book", book);
		
		return mav;
	}
	
	
	@RequestMapping(value = "/addForm", method = RequestMethod.POST)
	public String formAdd(@ModelAttribute("book") Book book){
		
		bookService.addBook(book);
		
		return "redirect:getall";
	}
	
}
