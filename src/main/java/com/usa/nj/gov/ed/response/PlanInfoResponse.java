package com.usa.nj.gov.ed.response;


import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="plan-info")
public class PlanInfoResponse {
	private Integer planId;
	private String planName;
	private String planStatus;
	private Date planStartDate;
	private Date planEndDate;
	private Double benfitAmount;
	private String denailReason;

}
