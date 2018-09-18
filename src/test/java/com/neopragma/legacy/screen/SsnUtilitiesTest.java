package com.neopragma.legacy.screen;

import com.neopragma.legacy.entity.JobApplicant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SsnUtilitiesTest {

    private JobApplicant jobApplicant;

    @Before
    public void beforeEach() {
        jobApplicant = new JobApplicant();
    }

    @Test
    public void ssnFormattingTest() {
        jobApplicant.setSsn("123456789");
        assertEquals("123-45-6789", jobApplicant.formatSsn());
    }

    @Test
    public void validSsnWithNoDashes() {
        jobApplicant.setSsn("123456789");
        assertEquals(0, jobApplicant.validateSsn());
    }

    @Test
    public void ssnWithDashesInWrongPlaces() {
        jobApplicant.setSsn("12-3456-789");
        assertEquals(1, jobApplicant.validateSsn());
    }

    @Test
    public void validSsnWithDashes() {
        jobApplicant.setSsn("123-45-6789");
        assertEquals(0, jobApplicant.validateSsn());
    }

    @Test
    public void ssnIsTooShort() {
        jobApplicant.setSsn("12345678");
        assertEquals(1, jobApplicant.validateSsn());
    }

    @Test
    public void ssnIsTooLong() {
        jobApplicant.setSsn("1234567890");
        assertEquals(1, jobApplicant.validateSsn());
    }

    @Test
    public void ssnAreaNumberIs000() {
        jobApplicant.setSsn("000223333");
        assertEquals(2, jobApplicant.validateSsn());
    }

    @Test
    public void ssnAreaNumberIs666() {
        jobApplicant.setSsn("666223333");
        assertEquals(2, jobApplicant.validateSsn());
    }

    @Test
    public void ssnAreaNumberStartsWith9() {
        jobApplicant.setSsn("900223333");
        assertEquals(2, jobApplicant.validateSsn());
    }

    @Test
    public void ssnSerialNumberIs0000() {
        jobApplicant.setSsn("111220000");
        assertEquals(3, jobApplicant.validateSsn());
    }

    @Test
    public void itRejectsSsn078051120() {
        jobApplicant.setSsn("078051120");
        assertEquals(4, jobApplicant.validateSsn());
    }

    @Test
    public void itRejectsSsn219099999() {
        jobApplicant.setSsn("219099999");
        assertEquals(4, jobApplicant.validateSsn());
    }
}
