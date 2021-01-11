package com.deretail.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SellDetails {

	@Id
	private int billItem;
	private int itemNo;
	private int productCode;
	private String productDescr;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	
	private int billNo;

	@Override
	public String toString() {
		return "sell details: " + billItem + " " + itemNo + " " + productCode 
				+ " " + quantity + " " + unitPrice + " " + totalPrice + "bill: " + billNo;
	}

	public int getBillItem() {
		return billItem;
	}

	public void setBillItem(int billItem) {
		this.billItem = billItem;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductDescr() {
		return productDescr;
	}

	public void setProductDescr(String productDescr) {
		this.productDescr = productDescr;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

}
