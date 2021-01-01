package com.deretail.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeRetailInventory {

	@Id
	private int driProductCode;
	private String driBrand;
	private String driProdDescr;
	private int driStock;
	private double driUnitPrice;
	private double driSellingPrice;
	
	public int getDriProductCode() {
		return driProductCode;
	}
	public void setDriProductCode(int driProductCode) {
		this.driProductCode = driProductCode;
	}
	public String getDriBrand() {
		return driBrand;
	}
	public void setDriBrand(String driBrand) {
		this.driBrand = driBrand;
	}
	public String getDriProdDescr() {
		return driProdDescr;
	}
	public void setDriProdDescr(String driProdDescr) {
		this.driProdDescr = driProdDescr;
	}
	public int getDriStock() {
		return driStock;
	}
	public void setDriStock(int driStock) {
		this.driStock = driStock;
	}
	public double getDriUnitPrice() {
		return driUnitPrice;
	}
	public void setDriUnitPrice(double driUnitPrice) {
		this.driUnitPrice = driUnitPrice;
	}
	public double getDriSellingPrice() {
		return driSellingPrice;
	}
	public void setDriSellingPrice(double driSellingPrice) {
		this.driSellingPrice = driSellingPrice;
	}
	@Override
	public String toString() {
		return "Inventory: " + driProductCode + " " + driBrand + " " + driStock + " " + driStock
				+ " " + driUnitPrice + " " + driSellingPrice;
	}
}
