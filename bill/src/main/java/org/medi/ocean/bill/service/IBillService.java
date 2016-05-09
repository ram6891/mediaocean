package org.medi.ocean.bill.service;

import org.medi.ocean.bill.model.BillDetail;
import org.medi.ocean.bill.model.Order;

public interface IBillService {
	
	BillDetail generateItemisedBill(Order order, boolean taxBasedOnCategory);
	
	void setCalculateService(ITaxCalculateService calculateService);

	void setProductService(IProductService productService);
}
