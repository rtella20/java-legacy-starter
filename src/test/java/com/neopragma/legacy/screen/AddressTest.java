package com.neopragma.legacy.screen;

import com.neopragma.legacy.entity.CityState;
import com.neopragma.legacy.utils.CityStateLookup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

/**
 * Automated unit checks for city state lookup service.
 * Uses a mock to replicate the remote call.
 *
 * @author neopragma
 * @version 1.0.0
 */

@RunWith(MockitoJUnitRunner.class)
public class AddressTest {

    @Mock
    private CityStateLookup cityStateLookup;

    @Test
    public void itFindsAddisonTexasBy5DigitZipCode() throws URISyntaxException, IOException {
        when(cityStateLookup.findCityStateBasedOnZipCode("75001")).thenReturn(new CityState("Addison", "TX"));
        assertCityState("75001", "Addison", "TX");
    }

    @Test
    public void itFindsMaranaArizonaBy9DigitZipCode() throws URISyntaxException, IOException {
        when(cityStateLookup.findCityStateBasedOnZipCode("856585578")).thenReturn(new CityState("Marana", "AZ"));
        assertCityState("856585578", "Marana", "AZ");
    }

    private void assertCityState(String zipCode, String city, String state) {
        CityState cityState = new CityState();
        try {
            cityState = cityStateLookup.findCityStateBasedOnZipCode(zipCode);
            assertEquals(city, cityState.getCity());
            assertEquals(state, cityState.getState());
        } catch(AssertionError failure) {
            fail("Expected: zipCode: " + zipCode + ", city: " + city + ", state: " + state +
                    " Actual: zipCode: " + zipCode + ", city: " + cityState.getCity() + ", state: " + cityState.getState());
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
    }


}
