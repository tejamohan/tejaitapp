package com.usa.nj.gov.ed.service;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;

public class CcapRulesService implements IRulesService {

	private static final Logger logger = LoggerFactory.getLogger(CcapRulesService.class);

	/**
	 * This Method is used for Ccap Based Business Rules
	 */
	@Override
	public PlanInfoResponse executeRules(IndvInfoRequest request) {

		logger.debug(" *** CcapRulesService :: CcapRulesService  started *** ");

		Double income = request.getMonthlyIncome();
		Integer kidsCount = request.getNoOfKids();
		PlanInfoResponse response = new PlanInfoResponse();
		response.setPlanName(request.getPlanName());

		if (income < 1000 && kidsCount > 0) {

			// Approved
			response.setPlanName("PlanApproved");
			response.setBenfitAmount(300.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(addOneMonth());

		} else {

			// Denied
			response.setPlanStatus("Denied");
			response.setDenailReason("Due to High Income or No Childrens");

		}

		logger.debug(" *** CcapRulesService :: CcapRulesServiceended *** ");
		logger.info(" *** CcapRulesService :: CcapRulesService Succesfull Completed *** ");

		return response;

	}

	/**
	 * THis Method is used for add one month
	 */
	public Date addOneMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}

}
