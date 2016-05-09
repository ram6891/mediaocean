package org.medi.ocean.bill.service;

import org.medi.ocean.bill.model.Product;

public interface ITaxCalculateService {
	Integer calculateTax(Product product, Long  shippingStateId, boolean taxBasedOnCategory);
	
	void setStateTaxDetailService(IStateTaxDetailService stateTaxDetailService);
}