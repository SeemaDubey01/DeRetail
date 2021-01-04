package com.deretail.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class DeRetailSellHeader {
	@Id
	private int drshBillNo;
	private String drshSeller;
	private int drshTotalItem;
	private double drshTotalBill;
	
	
    @OneToMany(targetEntity=DeRetailSellDetails.class,cascade=CascadeType.ALL )
    @JoinColumn(name = "drshBillNo", referencedColumnName="drshBillNo")
    private List<DeRetailSellDetails> sellDetails = new ArrayList<>();
 
	
	@Override
	public String toString() {
		return "bill: " + drshBillNo + " " + drshSeller + " " + drshTotalItem + " " + drshTotalBill;
	}
	public int getDrshBillNo() {
		return drshBillNo;
	}
	public void setDrshBillNo(int drshBillNo) {
		this.drshBillNo = drshBillNo;
	}
	public String getDrshSeller() {
		return drshSeller;
	}
	public void setDrshSeller(String drshSeller) {
		this.drshSeller = drshSeller;
	}
	public long getDrshTotalItem() {
		return drshTotalItem;
	}
	public void setDrshTotalItem(int drshTotalItem) {
		this.drshTotalItem = drshTotalItem;
	}
	public double getDrshTotalBill() {
		return drshTotalBill;
	}
	public void setDrshTotalBill(double drshTotalBill) {
		this.drshTotalBill = drshTotalBill;
	}
	public List<DeRetailSellDetails> getSellDetails() {
		return sellDetails;
	}
	public void setSellDetails(List<DeRetailSellDetails> sellDetails) {
		this.sellDetails = sellDetails;
	}	
	
}
