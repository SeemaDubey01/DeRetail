package com.deretail.dto;

import java.math.BigDecimal;

public class SearchProductDTO {
	private BigDecimal dtoProductCode;
	private String dtoBrand;
	private String dtoProductName;
	private String dtoSearchOption;
	
	public BigDecimal getDtoProductCode() {
		return dtoProductCode;
	}
	public void setDtoProductCode(BigDecimal dtoProductCode) {
		this.dtoProductCode = dtoProductCode;
	}
	public String getDtoBrand() {
		return dtoBrand;
	}
	public void setDtoBrand(String dtoBrand) {
		this.dtoBrand = dtoBrand;
	}
	public String getDtoProductName() {
		return dtoProductName;
	}
	public void setDtoProductName(String dtoProductName) {
		this.dtoProductName = dtoProductName;
	}
	public String getDtoSearchOption() {
		return dtoSearchOption;
	}
	public void setDtoSearchOption(String dtoSearchOption) {
		this.dtoSearchOption = dtoSearchOption;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "code: " + dtoProductCode + " brand: " + dtoBrand + " prodName: " + dtoProductName + " option: " + dtoSearchOption;
	}
	
	
	
}
