package com.deretail.dto;

import java.sql.Date;

public class SearchInvoiceDTO {
	private Date startDate;
	private Date endDate;
	private int billNo;
	private boolean billNoCheck;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public boolean isBillNoCheck() {
		return billNoCheck;
	}
	public void setBillNoCheck(boolean billNoCheck) {
		this.billNoCheck = billNoCheck;
	}
	

}
