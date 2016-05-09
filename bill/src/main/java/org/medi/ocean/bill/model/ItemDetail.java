package org.medi.ocean.bill.model;

public class ItemDetail {
	
	private Product product;
	private Integer serviceTax;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(Integer serviceTax) {
		this.serviceTax = serviceTax;
	}

}
