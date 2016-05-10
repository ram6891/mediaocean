package org.medi.ocean.bill.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.medi.ocean.bill.model.BillDetail;
import org.medi.ocean.bill.model.ItemDetail;
import org.medi.ocean.bill.model.Order;
import org.medi.ocean.bill.model.Product;
import org.medi.ocean.bill.service.IBillService;
import org.medi.ocean.bill.service.IProductService;
import org.medi.ocean.bill.service.ITaxCalculateService;
import org.medi.ocean.bill.service.context.ApplicationContextProvider;

public class BillServiceImpl implements IBillService{
	private ITaxCalculateService calculateService;
	private IProductService productService;
	
	public BillDetail generateItemisedBill(Order order, boolean taxBasedOnCategory) {
		
		BillDetail billDetail = new BillDetail();
		int totalAmount  =  0;
		int totalServiceTax = 0;
		List<ItemDetail> items =  new ArrayList<>();
		Product product = null;
		int serviceTax =  0;
		
		for(Long productId: order.getProductIds()) {
			ItemDetail detail = new ItemDetail();
			if(productService == null) {
				productService =  ApplicationContextProvider.getBean(IProductService.class);
			}
			product =productService.getProduct(productId);
			totalAmount += product.getPrice();
			if(calculateService == null) {
				calculateService =  ApplicationContextProvider.getBean(ITaxCalculateService.class);
			}
			serviceTax = calculateService.calculateTax(product, order.getShippingStateId(),taxBasedOnCategory);
			totalServiceTax  += serviceTax;
			detail.setProduct(product);
			detail.setServiceTax(serviceTax);
			items.add(detail);
		}
		billDetail.setItems(items);
		billDetail.setTotalAmount(totalAmount);
		billDetail.setTotalServiceTax(totalServiceTax);
		return billDetail;
	}

	public void setCalculateService(ITaxCalculateService calculateService) {
		this.calculateService = calculateService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

}

