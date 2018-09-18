package com.neopragma.legacy.integration;

import com.neopragma.legacy.entity.Address;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class CityStateLookupTest {
    private Address address;

    @Before
    public void beforeEach() {
        address = new Address();
    }

    @Test
    public void itFindsAddisonTexasBy5DigitZipCode() throws URISyntaxException, IOException {
        address.setZipCode("75001");
        assertEquals("Addison", address.getCity());
        assertEquals("TX", address.getState());
    }

    @Test
    public void itFindsMaranaArizonaBy9DigitZipCode() throws URISyntaxException, IOException {
        address.setZipCode("856585578");
        assertEquals("Marana", address.getCity());
        assertEquals("AZ", address.getState());
    }
}
