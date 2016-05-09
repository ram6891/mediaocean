package org.medi.ocean.service;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.medi.ocean.bill.model.BillDetail;
import org.medi.ocean.bill.model.Order;
import org.medi.ocean.bill.service.IBillService;
import org.medi.ocean.bill.service.IProductService;
import org.medi.ocean.bill.service.IStateTaxDetailService;
import org.medi.ocean.bill.service.ITaxCalculateService;
import org.medi.ocean.bill.service.impl.BillServiceImpl;
import org.medi.ocean.bill.service.impl.ProductServiceImpl;
import org.medi.ocean.bill.service.impl.StateTaxDetailServiceImpl;
import org.medi.ocean.bill.service.impl.TaxCalculateServiceImpl;

import junit.framework.TestCase;

public class BillServiceImplTest extends TestCase{
	private IBillService billServiceImpl;
	private ITaxCalculateService calculateService;
	private IProductService productService;
	private IStateTaxDetailService stateTaxDetailService;
	
	@Before
	public void setUp() {
		billServiceImpl = new BillServiceImpl();
		calculateService = new TaxCalculateServiceImpl();
		productService = new ProductServiceImpl();
		stateTaxDetailService = new StateTaxDetailServiceImpl();
		calculateService.setStateTaxDetailService(stateTaxDetailService);
		billServiceImpl.setCalculateService(calculateService);
		billServiceImpl.setProductService(productService);
	}

	@After
	public void tearDown() {
		billServiceImpl = new BillServiceImpl();
	}

	public void testGenerateBillAndTaxBasedOnCategoryA() {
		Order order = new Order();
		order.setOrderId(1L);
		order.setShippingStateId(1L);
		order.setProductIds(Arrays.asList(1L));
		BillDetail billDetail = billServiceImpl.generateItemisedBill(order, true);
		Assert.assertEquals(new Integer(5), billDetail.getTotalServiceTax());
		
	}
	
	public void testGenerateBillAndTaxBasedOnCategoryB() {
		Order order = new Order();
		order.setOrderId(2L);
		order.setShippingStateId(1L);
		order.setProductIds(Arrays.asList(2L));
		BillDetail billDetail = billServiceImpl.generateItemisedBill(order, true);
		Assert.assertEquals(new Integer(100), billDetail.getTotalServiceTax());
		
	}
	
	public void testGenerateBillAndTaxBasedOnCategoryC() {
		Order order = new Order();
		order.setOrderId(2L);
		order.setShippingStateId(1L);
		order.setProductIds(Arrays.asList(3L));
		BillDetail billDetail = billServiceImpl.generateItemisedBill(order, true);
		Assert.assertEquals(new Integer(0), billDetail.getTotalServiceTax());
		
	}
	
	public void testGenerateBillAndTaxBasedOnCategoryAAndB() {
		Order order = new Order();
		order.setOrderId(2L);
		order.setShippingStateId(1L);
		order.setProductIds(Arrays.asList(1L,2L));
		BillDetail billDetail = billServiceImpl.generateItemisedBill(order, true);
		Assert.assertEquals(new Integer(105), billDetail.getTotalServiceTax());
		
	}
	
	public void testGenerateBillAndTaxBasedOnState() {
		Order order = new Order();
		order.setOrderId(2L);
		order.setShippingStateId(2L);
		order.setProductIds(Arrays.asList(1L,2L));
		BillDetail billDetail = billServiceImpl.generateItemisedBill(order, false);
		Assert.assertEquals(new Integer(110), billDetail.getTotalServiceTax());
		
	}
	
	public void testGenerateBillAndTaxBasedOnDifferentState() {
		Order order = new Order();
		order.setOrderId(3L);
		order.setShippingStateId(3L);
		order.setProductIds(Arrays.asList(1L,3L));
		BillDetail billDetail = billServiceImpl.generateItemisedBill(order, false);
		Assert.assertEquals(new Integer(315), billDetail.getTotalServiceTax());
		
	}
}
