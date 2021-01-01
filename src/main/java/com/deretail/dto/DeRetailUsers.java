package com.deretail.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeRetailUsers {

	@Id
	private String druUserName;
	private String druPassword;
	private String druRole;
	private boolean druActive;
	
	public String getDruUserName() {
		return druUserName;
	}
	public void setDruUserName(String druUserName) {
		this.druUserName = druUserName;
	}
	public String getDruPassword() {
		return druPassword;
	}
	public void setDruPassword(String druPassword) {
		this.druPassword = druPassword;
	}
	public String getDruRole() {
		return druRole;
	}
	public void setDruRole(String druRole) {
		this.druRole = druRole;
	}
	public boolean isDruActive() {
		return druActive;
	}
	public void setDruActive(boolean druActive) {
		this.druActive = druActive;
	}
	
}
