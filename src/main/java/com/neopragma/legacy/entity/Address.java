package com.neopragma.legacy.entity;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Represents an address for the job applicant
 *
 * @author neopragma
 * @version 1.0.0
 */

public class Address {

    private String zipCode;
    private CityState cityState;

    public Address(String zipCode, CityState cityState) {
        this.zipCode = zipCode;
        this.cityState = cityState;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.cityState.getCity();
    }

    public String getState() {
        return this.cityState.getState();
    }
}
