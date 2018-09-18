package com.neopragma.legacy.entity;

import java.io.IOException;
import java.net.URISyntaxException;

import com.neopragma.legacy.dao.JobApplicantDao;
import com.neopragma.legacy.utils.CityStateLookup;
import com.neopragma.legacy.utils.SsnUtilities;

/**
 * This class represents a job applicant entity.
 * This version currently handles a number of responsibilities.
 *
 * @author neopragma
 * @version 1.0.0
 */
public class JobApplicant {
	
	private Name name;
	private String ssn;
	private Address address;
	private JobApplicantDao jobApplicantDao;
	private CityStateLookup cityStateLoopkup;

	public JobApplicant(){
		cityStateLoopkup = new CityStateLookup();
	}

	public void setName(String firstName, String middleName, String lastName) {
		this.name = new Name(firstName, middleName, lastName);
	}

	public String formatLastNameFirst() {
		return this.name.formatLastNameFirst();
	}

	public void setSsn(String ssn) {
		SsnUtilities ssnUtilities = new SsnUtilities();
		this.ssn = ssnUtilities.removeHyphens(ssn);
	}

	public String getCity() {
		return address.getCity();
	}

	public String getState() {
		return address.getState();
	}
	
	public void add(String firstName,
			       String middleName,
			       String lastName,
			       String ssn,
			       String zipCode) throws URISyntaxException, IOException {
		setName(firstName, middleName, lastName);
		setSsn(ssn);
		setAddress(zipCode);
		jobApplicantDao.save(this);
	}

	public void setAddress(String zipCode) throws IOException, URISyntaxException {
		address = new Address(zipCode, cityStateLoopkup.findCityStateBasedOnZipCode(zipCode));
	}
}
