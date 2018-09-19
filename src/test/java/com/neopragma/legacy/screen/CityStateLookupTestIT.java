package com.neopragma.legacy.screen;

import com.neopragma.legacy.entity.Address;
import com.neopragma.legacy.entity.CityState;
import com.neopragma.legacy.utils.CityStateLookup;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

/**
 * Integration test to make the remote call to fetch city and state based on a zip code
 * TODO: provision to run separately from unit tests
 *
 * @author neopragma
 * @version 1.0.0
 */
public class CityStateLookupTestIT {
    private CityStateLookup cityStateLookup;

    @Before
    public void beforeEach() {
        cityStateLookup = new CityStateLookup();
    }

    @Test
    public void itFindsAddisonTexasBy5DigitZipCode() throws URISyntaxException, IOException {
        CityState cityState = new CityState();
        cityState = cityStateLookup.findCityStateBasedOnZipCode("75001");
        assertEquals("Addison", cityState.getCity());
        assertEquals("TX", cityState.getState());
    }

    @Test
    public void itFindsMaranaArizonaBy9DigitZipCode() throws URISyntaxException, IOException {
        CityState cityState = new CityState();
        cityState = cityStateLookup.findCityStateBasedOnZipCode("856585578");
        assertEquals("Marana", cityState.getCity());
        assertEquals("AZ", cityState.getState());
    }
}
