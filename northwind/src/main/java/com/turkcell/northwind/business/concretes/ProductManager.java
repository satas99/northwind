package com.turkcell.northwind.business.concretes;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turkcell.northwind.business.abstracts.ProductService;
import com.turkcell.northwind.business.dtos.GetProductByNameDto;
import com.turkcell.northwind.business.dtos.ListProductDto;
import com.turkcell.northwind.business.requests.CreateProductRequest;
import com.turkcell.northwind.core.utilities.mapping.ModelMapperService;
import com.turkcell.northwind.core.utilities.results.DataResult;
import com.turkcell.northwind.core.utilities.results.ErrorDataResult;
import com.turkcell.northwind.core.utilities.results.Result;
import com.turkcell.northwind.core.utilities.results.SuccessDataResult;
import com.turkcell.northwind.core.utilities.results.SuccessResult;
import com.turkcell.northwind.dataAccess.abstracts.ProductDao;
import com.turkcell.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ProductManager(ProductDao productDao, ModelMapperService modelMapperService) {
		this.productDao = productDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListProductDto>> getAll() {
		var result = this.productDao.findAll();
		List<ListProductDto> response = result.stream()
				.map(product -> this.modelMapperService.forDto().map(product, ListProductDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListProductDto>>(response);
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productDao.save(product);
		return new SuccessResult("Product.Added");
	}

	@Override
	public DataResult<GetProductByNameDto> getProductByName(String productName) {
		Product product= this.productDao.getByProductName(productName);
		if(product==null) {
			return new ErrorDataResult<GetProductByNameDto>(null,"Product.NotFound");
		}
		GetProductByNameDto result = this.modelMapperService.forDto().map(product, GetProductByNameDto.class);
		
		return new SuccessDataResult<GetProductByNameDto>(result);
	}

	@Override
	public DataResult<List<ListProductDto>> getAllPaged(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize );
		
		List<Product> result = this.productDao.findAll(pageable).getContent();
		
		List<ListProductDto> response = result.stream()
				.map(product -> this.modelMapperService.forDto().map(product, ListProductDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListProductDto>>(response);
	}

	@Override
	public DataResult<List<ListProductDto>> getAllSorted() {
		Sort sort= Sort.by(Sort.Direction.DESC,"productName");
		List<Product> result = this.productDao.findAll(sort);
		List<ListProductDto> response = result.stream()
				.map(product -> this.modelMapperService.forDto().map(product, ListProductDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListProductDto>>(response);
	}

}
