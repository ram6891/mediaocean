package org.medi.ocean.bill.service.impl;

import org.medi.ocean.bill.model.Product;
import org.medi.ocean.bill.model.StateDetail;
import org.medi.ocean.bill.service.IStateTaxDetailService;
import org.medi.ocean.bill.service.ITaxCalculateService;
import org.medi.ocean.bill.service.context.ApplicationContextProvider;

public class TaxCalculateServiceImpl implements ITaxCalculateService{
	private IStateTaxDetailService stateTaxDetailService;
	
	
	public Integer calculateTax(Product product, Long  shippingStateId, boolean taxBasedOnCategory)  {
		if(taxBasedOnCategory) {
			return calculateTaxOnCategory(product);
		}
		else{
			return calculateTaxBasedOnState(product, shippingStateId);
		}
	}
	
	private Integer calculateTaxOnCategory(Product  product) {
		return product.getPrice()* product.getCategory().getSaleTaxPercentage()/100;
	}
	
	private Integer calculateTaxBasedOnState(Product product, Long shippingStateId)  {
		if(stateTaxDetailService == null) {
			stateTaxDetailService = ApplicationContextProvider.getBean(IStateTaxDetailService.class);
		}
		StateDetail  detail = stateTaxDetailService.getStateTax(shippingStateId);
		return product.getPrice()* detail.getSaleTaxPercentage()/100;
	}
	
	public void setStateTaxDetailService(IStateTaxDetailService stateTaxDetailService) {
		this.stateTaxDetailService = stateTaxDetailService;
	}

}
