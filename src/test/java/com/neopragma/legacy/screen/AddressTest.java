package com.neopragma.legacy.screen;

import com.neopragma.legacy.entity.JobApplicant;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    private JobApplicant jobApplicant;

    @Before
    public void beforeEach() {
        jobApplicant = new JobApplicant();
    }

    @Test
    public void itFindsAddisonTexasBy5DigitZipCode() throws URISyntaxException, IOException {
        jobApplicant.setZipCode("75001");
        assertEquals("Addison", jobApplicant.getCity());
        assertEquals("TX", jobApplicant.getState());
    }

    @Test
    public void itFindsMaranaArizonaBy9DigitZipCode() throws URISyntaxException, IOException {
        jobApplicant.setZipCode("856585578");
        assertEquals("Marana", jobApplicant.getCity());
        assertEquals("AZ", jobApplicant.getState());
    }

}