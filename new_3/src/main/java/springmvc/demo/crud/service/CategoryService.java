package springmvc.demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.demo.crud.entity.Category;
import springmvc.demo.crud.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public void save(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> findAll() {
	  return  (List<Category>) categoryRepository.findAll();
	}
}
