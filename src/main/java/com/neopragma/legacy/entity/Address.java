package com.neopragma.legacy.entity;
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
