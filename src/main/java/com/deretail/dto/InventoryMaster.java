package com.deretail.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InventoryMaster {

	@Id
	private int productCode;
	private String brand;
	private String prodDescr;
	private int stock;
	private double unitPrice;
	private double sellingPrice;
	
	@Override
	public String toString() {
		return "Inventory: " + productCode + " " + brand + " " + stock + " " + stock
				+ " " + unitPrice + " " + sellingPrice;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProdDescr() {
		return prodDescr;
	}

	public void setProdDescr(String prodDescr) {
		this.prodDescr = prodDescr;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
}
