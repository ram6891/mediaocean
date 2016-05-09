package org.medi.ocean.bill.service.impl;


import org.medi.ocean.bill.model.Category;
import org.medi.ocean.bill.model.Product;
import org.medi.ocean.bill.model.ProductCategory;
import org.medi.ocean.bill.service.IProductService;

public class ProductServiceImpl implements IProductService{
	
	public Product getProduct(Long productId) {
		return getProductDetail(productId);
	}
	
	private Product getProductDetail(Long productId) {
		Product product = new Product();
		if(productId == 1) {
			product.setName("Lux");
			product.setCategory(new ProductCategory(1L, Category.A, 10));
			product.setProductId(productId);
			product.setPrice(50);
		}
		else if(productId == 2) {
			product.setName("Amul Milk");
			product.setCategory(new ProductCategory(1L, Category.B, 20));
			product.setProductId(productId);
			product.setPrice(500);
		}
		else if(productId == 3) {
			product.setName("Mobile");
			product.setCategory(new ProductCategory(1L, Category.C, 0));
			product.setProductId(productId);
			product.setPrice(1000);
		}
		return product;
	}
	
}