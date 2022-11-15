package com.usa.nj.gov.ed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.nj.gov.ed.request.IndvInfoRequest;
import com.usa.nj.gov.ed.response.PlanInfoResponse;
import com.usa.nj.gov.ed.service.EdRulesService;

@RestController
public class EdRulesController {

	private static final Logger logger = LoggerFactory.getLogger(EdRulesController.class);
	
	@Autowired
	private EdRulesService edRulesService;

	/**
	 * This method is used for Determination Eligibility
	 * @param request
	 * @return PlanInfoResponse
	 * @tejamunakala kill your ego
         * take this code to next level high
	 * @tejeswaraReddy munakala kill ego first
	 */
	@PostMapping(value = "/checkingEl", produces = { "application/xml", "application/json" }, consumes = {
			"application/xml", "application/json" })
	public @ResponseBody PlanInfoResponse checkingEligibility(@RequestBody IndvInfoRequest request) {
		
		logger.debug(" *** EdRulesController :: checkingEligibility() method started *** ");
		
		PlanInfoResponse response = null;
		
		response = edRulesService.findEligibility(request);
		
		logger.debug(" ***** EdRulesController :: checkingEligibility() method ended ***** ");
		logger.info(" *** EdRulesController :: Eligibility Determination Completed Successfully *** ");
		
		return response;

	}

}
