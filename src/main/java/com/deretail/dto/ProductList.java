package com.deretail.dto;

import java.util.List;

public class ProductList {

	private List<BrandMaster> productArray;

		
	public List<BrandMaster> getProductArray() {
		return productArray;
	}

	public void setProductArray(List<BrandMaster> productArray) {
		this.productArray = productArray;
	}

	public int getSize() {
		return productArray.size();
	}

	@Override
	public String toString() {
		String temp = " ";
		for (BrandMaster b: productArray) {
			temp = temp + b.toString();
		}
		return temp;
	}
	
}
