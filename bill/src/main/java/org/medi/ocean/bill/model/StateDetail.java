package org.medi.ocean.bill.model;

public class StateDetail {
	private Long stateId;
	private String stateName;
	private Integer saleTaxPercentage;
	
	public Long getStateTaxDetailId() {
		return stateId;
	}
	public void setStateTaxDetailId(Long stateTaxDetailId) {
		this.stateId = stateTaxDetailId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getSaleTaxPercentage() {
		return saleTaxPercentage;
	}
	public void setSaleTaxPercentage(Integer saleTaxPercentage) {
		this.saleTaxPercentage = saleTaxPercentage;
	}
}
