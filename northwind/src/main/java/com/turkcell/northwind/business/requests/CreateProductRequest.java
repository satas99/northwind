package com.turkcell.northwind.business.requests;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	@NotNull
	@Size(min=2, max=50)
	private String productName;
	
	@NotNull
	@Min(0)
	@Max(100)
	private double unitPrice;

	@NotNull
	@Size(min=2, max=50)
	private String quantityPerUnit;
	
	@NotNull
	@Min(1)
	@Max(100)
	private int unitsInStock;
	
	@NotNull
	private int categoryId;
}
