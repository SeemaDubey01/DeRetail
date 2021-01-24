package com.deretail.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemStock {
	
	@Id
	private BigDecimal barcode;
	private int stock;
	private double unitPrice;
	private double sellingPrice;
	private Date mfgDate;
	private Date expiryDate;
	
	@Override
	public String toString() {
		return "InventoryStock: " + barcode + " " + stock + " " + unitPrice + " " + sellingPrice
				+ " " + mfgDate + " " + expiryDate ;
	}

	public BigDecimal getBarcode() {
		return barcode;
	}

	public void setBarcode(BigDecimal barcode) {
		this.barcode = barcode;
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

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
