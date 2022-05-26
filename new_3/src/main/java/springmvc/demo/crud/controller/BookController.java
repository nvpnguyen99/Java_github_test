package springmvc.demo.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.demo.crud.entity.Book;
import springmvc.demo.crud.entity.Category;
import springmvc.demo.crud.service.BookService;
import springmvc.demo.crud.service.CategoryService;

@Controller
public class BookController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/addBook")
	public String addBook(Model model) {
		List<Category> categoryList = categoryService.findAll();
		
		model.addAttribute("book", new Book());
		model.addAttribute("categoryList", categoryList);
		return "addBook";
	}
	
	@PostMapping("/doAddBook")
	public String doAddBook(@Valid @ModelAttribute(name="book") Book book ,BindingResult rs, Model model) {
		
		if(rs.hasErrors()) {
			List<Category> categoryList = categoryService.findAll();
			model.addAttribute("categoryList", categoryList);
			return "addBook";
		}
		
		bookService.save(book);
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "index";
	}
	
	@GetMapping(value = {"/" , "/index"})
	public String index(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "index";
	}
	
	@GetMapping(value = {"/updateBook"})
	public String updateBook(Model model, @RequestParam(name = "id") int id ) {
		Optional<Book> opt_Book = bookService.findById(id) ;
		List<Category> categoryList = categoryService.findAll();
		if (opt_Book.isPresent()) {
			model.addAttribute("book", opt_Book.get());
			model.addAttribute("categoryList", categoryList);
		} else {
			return"error";
		}
		return "updateBook";
	}
	
	@PostMapping("/doUpdateBook")
	public String doUpdateBook(@Valid @ModelAttribute(name="book") Book book ,BindingResult rs, Model model) {
		
		if(rs.hasErrors()) {
			List<Category> categoryList = categoryService.findAll();
			model.addAttribute("categoryList", categoryList);
			return "UpdateBook";
		}
		book.getBookDetails().setId(book.getId());
		bookService.save(book);
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "index";
	}
	
	@GetMapping(value = {"/dodeleteBook"})
	public String dodeleteBook(Model model, @RequestParam(name = "id") int id ) {
		bookService.deleteById(id);
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "index";
	}
	
	@GetMapping(value = {"/search"})
	public String search(Model model, @RequestParam(name = "keyword") String keyword ) {
		
		List<Book> bookList = bookService.findByCri(keyword);
		model.addAttribute("bookList", bookList);
		return "index";
	}
}
