package com.gutotech.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.course.entities.Category;
import com.gutotech.course.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id) {
		return ResponseEntity.ok(categoryService.findById(id));
	}
}
