package org.medi.ocean.bill.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.medi.ocean.bill.model.BillDetail;
import org.medi.ocean.bill.model.Order;
import org.medi.ocean.bill.service.IBillService;
import org.medi.ocean.bill.service.context.ApplicationContextProvider;

@Path("/")
public class BillResource {
	

	@POST
	@Path("/billBasedOnCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BillDetail getGeneratedBillOnCategoryTax(Order order) {
		return ApplicationContextProvider.getBean(IBillService.class).generateItemisedBill(order, true);
	}
	
	@POST
	@Path("/billBasedOnStateTax")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BillDetail getGeneratedBillOnStateTax(Order  order) {
		return ApplicationContextProvider.getBean(IBillService.class).generateItemisedBill(order, false);
	}
}
