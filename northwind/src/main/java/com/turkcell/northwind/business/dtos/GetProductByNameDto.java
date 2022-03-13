package com.turkcell.northwind.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByNameDto {
	private int productId;
	private String productName;
	private double unitPrice;
	private String quantityPerUnit;
	private int unitsInStock;
	private String categoryName;
}
