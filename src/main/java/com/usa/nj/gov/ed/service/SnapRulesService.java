package com.usa.nj.gov.ed.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;

public class SnapRulesService implements IRulesService {

	private static final Logger logger = LoggerFactory.getLogger(SnapRulesService.class);

	/**
	 * This Method is used for Snap Based Business Rules
	 */
	@Override
	public PlanInfoResponse executeRules(IndvInfoRequest request) {

		logger.debug(" *** SnapRulesService ::  SnapRulesService started *** ");

		Double income = request.getMonthlyIncome();
		PlanInfoResponse response = new PlanInfoResponse();
		if (income > 1000) {
			// denied
			response.getPlanName();
			response.setPlanStatus("Denied");
			response.setDenailReason("Due to High Income");

		} else {
			// approved
			response.setPlanStatus("Plan Approved");
			response.setBenfitAmount(300.00);
			response.setPlanStartDate(new Date());
			response.setPlanEndDate(addOneMonth());
		}

		logger.debug(" *** SnapRulesService :: SnapRulesService ended *** ");
		logger.info(" *** SnapRulesService :: SnapRules Completed Succefull *** ");

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