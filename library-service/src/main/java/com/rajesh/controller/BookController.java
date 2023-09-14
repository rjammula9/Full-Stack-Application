
package com.rajesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.rajesh.model.Book;
import com.rajesh.service.BookService;
import java.util.List;

@Controller

@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}




	@GetMapping("/getAll")
	public String listBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		System.out.println("Books in controller:" + books);
		model.addAttribute("books", books);
		return "book/list";
	}
	@GetMapping
	public String getJsp(Model model) {
		List<Book> books=bookService.getAllBooks();
		model.addAttribute("books",books);
		return "books";
	}


	// GET Request to show a form for adding a new book

	@GetMapping("/book/add")
	public String showAddForm(Model model) {
		model.addAttribute("book", new Book());
		return "book/add";
	}

	// POST Request to add a new book

	@PostMapping("/book/add")
	public ModelAndView addBook(@ModelAttribute("book") Book book) {
		ModelAndView modelandview = new ModelAndView("/books");
		bookService.addBook(book);
		List<Book> b = bookService.getAllBooks();
		System.out.println("controller book objects " + b);
		modelandview.addObject("books", b);
		return modelandview;
	}

	@GetMapping("/book/edit/{id}")
	public ModelAndView showEditForm(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("book/edit");
		Book book = bookService.getBookById(id);
		modelAndView.addObject("book", book);
		return modelAndView;
	}

	@PutMapping("/book/edit/{id}")
	public ModelAndView editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
		ModelAndView modelAndView = new ModelAndView("redirect:/books"); // Redirect
		if (bookService.updateBook(id, book)) {
			return modelAndView;
		}
		return modelAndView;
	}

	@GetMapping("/book/delete/{id}")
	public ModelAndView showDeleteConfirmation(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("book/delete");
		Book book = bookService.getBookById(id);
		modelAndView.addObject("book", book);
		return modelAndView;
	}

	@DeleteMapping("/book/delete/{id}")
	public ModelAndView deleteBook(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/books");
		bookService.deleteBook(id);
		return modelAndView;
	}
}
