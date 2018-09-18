package com.neopragma.legacy.entity;
/**
 * Represents city and state for the address
 *
 * @author neopragma
 * @version 1.0.0
 */
public class CityState {
    private String city;
    private String state;

    public CityState (String city, String state){
        this.city = city;
        this.state = state;
    }

    public CityState(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
