package org.medi.ocean.bill.service;

import org.medi.ocean.bill.model.StateDetail;

public interface IStateTaxDetailService {
	
	 StateDetail getStateTax(Long shippingStateId);

}
