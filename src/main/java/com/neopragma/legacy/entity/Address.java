package com.neopragma.legacy.entity;

import com.neopragma.legacy.utils.CityStateLookup;

/**
 * Represents an address for the job applicant
 *
 * @author neopragma
 * @version 1.0.0
 */
public class Address {

    private String zipCode;
    private CityState cityState;
    private CityStateLookup cityStateLoopkup;

    public Address(String zipCode) {
        this.zipCode = zipCode;
        setCityState(zipCode);
    }

    private void setCityState(String zipCode){
        cityStateLoopkup = new CityStateLookup();
        this.cityState = cityStateLoopkup.findCityStateBasedOnZipCode(zipCode);
    }

    private void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.cityState.getCity();
    }

    public String getState() {
        return this.cityState.getState();
    }
}
