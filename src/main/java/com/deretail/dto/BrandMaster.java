package com.deretail.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BrandMaster {

	@Id
	private BigDecimal barcode;
	private String brand;
	private String sku;
	private String prodName;
	private String category;
	
	@Override
	public String toString() {
		return "InventoryMaster: " + barcode + " " + brand + " " + sku + " " + prodName
				+ " " + category;
	}

	public BigDecimal getBarcode() {
		return barcode;
	}

	public void setBarcode(BigDecimal barcode) {
		this.barcode = barcode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
