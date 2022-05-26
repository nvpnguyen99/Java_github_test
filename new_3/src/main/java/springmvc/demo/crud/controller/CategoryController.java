package springmvc.demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springmvc.demo.crud.entity.Category;
import springmvc.demo.crud.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/addCategory")
	public String index(Model model) {
		model.addAttribute("category", new Category());
		return "addCategory";
	}
	
	@PostMapping("/doAddCategory")
	public String doAddCategory(Category category) {
		categoryService.save(category);
		return "index";
	}
}
