package com.neopragma.legacy.entity;

import com.neopragma.legacy.dao.JobApplicantDao;
import com.neopragma.legacy.utils.CityStateLookup;
import com.neopragma.legacy.utils.SsnUtilities;

/**
 * This class represents a job applicant entity.
 *
 * @author neopragma
 * @version 1.0.0
 */
public class JobApplicant {
	
	private Name name;
	private String ssn;
	private Address address;
	private JobApplicantDao jobApplicantDao;

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


	/** TODO: could this be dropped in favor of JobApplicant persistence layer?
	 *  There is already a save operation exist in the persistence layer.
	 *  Keeping this for now because of the existing public API
	 */
	public void add(String firstName,
			       String middleName,
			       String lastName,
			       String ssn,
			       String zipCode) {
		setName(firstName, middleName, lastName);
		setSsn(ssn);
		setAddress(zipCode);
		jobApplicantDao.save(this);
	}

	public void setAddress(String zipCode) {
		this.address = new Address(zipCode);
	}
}
