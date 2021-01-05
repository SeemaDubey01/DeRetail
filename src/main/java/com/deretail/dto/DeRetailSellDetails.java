package com.deretail.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeRetailSellDetails {

	@Id
	private int drsdBillItem;
	private int drsdItemNo;
	private int drsdProductCode;
	private int drsdQuantity;
	private double drsdUnitPrice;
	private double drsdTotalPrice;
	
	private int drshBillNo;

	@Override
	public String toString() {
		return "sell details: " + drsdBillItem + " " + drsdItemNo + " " + drsdProductCode 
				+ " " + drsdQuantity + " " + drsdUnitPrice + " " + drsdTotalPrice + "bill: " + drshBillNo;
	}

	public int getDrsdBillItem() {
		return drsdBillItem;
	}

	public void setDrsdBillItem(int drsdBillItem) {
		this.drsdBillItem = drsdBillItem;
	}

	public int getDrsdItemNo() {
		return drsdItemNo;
	}

	public void setDrsdItemNo(int drsdItemNo) {
		this.drsdItemNo = drsdItemNo;
	}

	public int getDrsdProductCode() {
		return drsdProductCode;
	}

	public void setDrsdProductCode(int drsdProductCode) {
		this.drsdProductCode = drsdProductCode;
	}

	public int getDrsdQuantity() {
		return drsdQuantity;
	}

	public void setDrsdQuantity(int drsdQuantity) {
		this.drsdQuantity = drsdQuantity;
	}

	public double getDrsdUnitPrice() {
		return drsdUnitPrice;
	}

	public void setDrsdUnitPrice(double drsdUnitPrice) {
		this.drsdUnitPrice = drsdUnitPrice;
	}

	public double getDrsdTotalPrice() {
		return drsdTotalPrice;
	}

	public void setDrsdTotalPrice(double drsdTotalPrice) {
		this.drsdTotalPrice = drsdTotalPrice;
	}

	public int getDrshBillNo() {
		return drshBillNo;
	}

	public void setDrshBillNo(int drshBillNo) {
		this.drshBillNo = drshBillNo;
	}
}
