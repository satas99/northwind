package com.turkcell.northwind.business.abstracts;

import java.util.List;

import com.turkcell.northwind.business.dtos.GetProductByNameDto;
import com.turkcell.northwind.business.dtos.ListProductDto;
import com.turkcell.northwind.business.requests.CreateProductRequest;
import com.turkcell.northwind.core.utilities.results.DataResult;
import com.turkcell.northwind.core.utilities.results.Result;


public interface ProductService {
	DataResult<List<ListProductDto>> getAll();
	Result add(CreateProductRequest createProductRequest);
	DataResult<GetProductByNameDto> getProductByName(String productName);
	DataResult<List<ListProductDto>> getAllPaged(int pageNo, int pageSize);
	DataResult<List<ListProductDto>> getAllSorted();
}
