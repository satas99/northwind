package com.turkcell.northwind.business.abstracts;

import java.util.List;

import com.turkcell.northwind.business.dtos.ListCategoryDto;
import com.turkcell.northwind.business.requests.CreateCategoryRequest;


public interface CategoryService {
	List<ListCategoryDto> getAll();
	void add(CreateCategoryRequest createCategoryRequest);
}
