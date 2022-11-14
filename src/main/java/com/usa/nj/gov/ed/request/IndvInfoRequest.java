package com.usa.nj.gov.ed.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="indv-info")
public class IndvInfoRequest {
	
	private Integer indvId;
	private String planName;
	private Long ssn;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private Double monthlyIncome;
	private Integer noOfKids;
	private String maritualStatus;
	private boolean qhpPurchased;
	private Double monthlyOtherIncome;
	
	

}
