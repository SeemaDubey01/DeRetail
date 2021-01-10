package com.deretail.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SellHeader {
	@Id
	private int billNo;
	private String seller;
	private int totalItem;
	private double totalBill;
	
	
    @OneToMany(targetEntity=SellDetails.class,cascade=CascadeType.ALL )
    @JoinColumn(name = "billNo", referencedColumnName="billNo")
    private List<SellDetails> sellDetails = new ArrayList<>();
 
	
	@Override
	public String toString() {
		return "bill: " + billNo + " " + seller + " " + totalItem + " " + totalBill;
	}


	public int getBillNo() {
		return billNo;
	}


	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}


	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	public int getTotalItem() {
		return totalItem;
	}


	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}


	public double getTotalBill() {
		return totalBill;
	}


	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}


	public List<SellDetails> getSellDetails() {
		return sellDetails;
	}


	public void setSellDetails(List<SellDetails> sellDetails) {
		this.sellDetails = sellDetails;
	}
	
}
