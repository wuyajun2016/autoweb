package com.auction.bean;

public class StartCredit {

	private String customerName;
	private int identifyType;
	private String identifyNo;
	private int maritalStatus;
	private String investigationBank;
	private String cellPhone;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(int identifyType) {
		this.identifyType = identifyType;
	}
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	public int getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getInvestigationBank() {
		return investigationBank;
	}
	public void setInvestigationBank(String investigationBank) {
		this.investigationBank = investigationBank;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Override
	public String toString() {
		return"customerName=" + customerName + "identifyType=" + identifyType + "identifyNo=" + identifyNo + "maritalStatus="
		+ maritalStatus +"investigationBank=" + investigationBank + "cellPhone=" + cellPhone+ "\n";
	}
	
}
