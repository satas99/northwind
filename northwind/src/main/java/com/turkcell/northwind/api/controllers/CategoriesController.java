package com.turkcell.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.northwind.business.abstracts.CategoryService;
import com.turkcell.northwind.business.dtos.ListCategoryDto;
import com.turkcell.northwind.business.requests.CreateCategoryRequest;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {

		this.categoryService = categoryService;
	}

	@GetMapping("/getall")
	public List<ListCategoryDto> getAll() {
		return this.categoryService.getAll();

	}

	@PostMapping("/add")
	public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		this.categoryService.add(createCategoryRequest);

	}
}