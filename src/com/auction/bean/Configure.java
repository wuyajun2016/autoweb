package com.auction.bean;

public class Configure {

	private int maritalStatus;
	private int relationship;
	private int guarantor;
	private int customeralready;
	private String carname;


	public String getCarname() {
		return carname;
	}



	public void setCarname(String carname) {
		this.carname = carname;
	}



	public int getCustomeraready() {
		return customeralready;
	}



	public void setCustomeraready(int customeralready) {
		this.customeralready = customeralready;
	}



	public int getMaritalStatus() {
		return maritalStatus;
	}



	public int getGuarantor() {
		return guarantor;
	}



	public void setGuarantor(int guarantor) {
		this.guarantor = guarantor;
	}



	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	public int getRelationship() {
		return relationship;
	}



	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}



	@Override
	public String toString() {
		return"maritalStatus=" + maritalStatus + "relationship=" + relationship + "\n";
	}
	
}
