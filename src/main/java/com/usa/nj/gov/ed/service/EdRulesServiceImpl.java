package com.usa.nj.gov.ed.service;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;

@Service
public class EdRulesServiceImpl implements EdRulesService {

	private static final Logger logger = LoggerFactory.getLogger(EdRulesServiceImpl.class);

	/**
	 * This method is used to execute Eligibility Rules based on Plan Name
	 */
	@Override
	public PlanInfoResponse findEligibility(IndvInfoRequest request) {

		logger.debug(" **** EdRulesServiceImpl :: findEligibility() method started **** ");

		String planName = request.getPlanName();
		PlanInfoResponse response = null;

		try {

			Class clz = Class.forName("com.usa.nj.gov.ed.service." + planName + "RulesService");
			Object obj = clz.newInstance();
			Method method = clz.getDeclaredMethod("executeRules", IndvInfoRequest.class);
			Object retObj = method.invoke(obj, request);
			response = (PlanInfoResponse) retObj;

		} catch (Exception e) {
			logger.info(" **** EdRulesServiceImpl ::  findEligibility() Exception Occured **** "+e.getMessage());

		}

		logger.debug(" **** EdRulesServiceImpl :: findEligibility() method ended **** ");
		logger.info(" **** EdRulesServiceImpl ::  findEligibility() Completed Successful **** ");

		return response;
	}

}
