package com.neopragma.legacy.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.neopragma.legacy.dao.JobApplicantDao;
import com.neopragma.legacy.dao.JobApplicantDaoImpl;
import com.neopragma.legacy.utils.SsnUtilities;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

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

	public JobApplicant(){
		address = new Address();
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

	public void setZipCode(String zipCode) throws URISyntaxException, IOException {
		address.setZipCode(zipCode);
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
		setZipCode(zipCode);
		jobApplicantDao.save(this);
	}


}
