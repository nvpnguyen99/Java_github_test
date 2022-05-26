package springmvc.demo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.demo.crud.entity.Book;
import springmvc.demo.crud.entity.Category;
import springmvc.demo.crud.repository.BookRepository;
import springmvc.demo.crud.repository.CategoryRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}
	
	public Optional<Book> findById(int id) {
		return bookRepository.findById(id);
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> findByCri (String keyword){
		return bookRepository.findByCri(keyword);
	}
}
