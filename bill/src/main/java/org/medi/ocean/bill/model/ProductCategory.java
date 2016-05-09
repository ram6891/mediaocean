package org.medi.ocean.bill.model;

public class ProductCategory {
	
	private Long categoryId;
	private Category category;
	private Integer saleTaxPercentage;
	
	public ProductCategory() {
		
	}
	
	public ProductCategory(Long  categoryId, Category category, Integer saleTaxPercentage) {
		this.category = category;
		this.categoryId = categoryId;
		this.saleTaxPercentage = saleTaxPercentage;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getSaleTaxPercentage() {
		return saleTaxPercentage;
	}
	public void setSaleTaxPercentage(Integer saleTaxPercentage) {
		this.saleTaxPercentage = saleTaxPercentage;
	}

}
