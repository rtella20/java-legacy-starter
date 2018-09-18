package com.neopragma.legacy.screen;

import com.neopragma.legacy.entity.JobApplicant;
import com.neopragma.legacy.utils.SsnUtilities;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SsnUtilitiesTest {

    private JobApplicant jobApplicant;
    private SsnUtilities ssnUtilities;

    @Before
    public void beforeEach() {
        jobApplicant = new JobApplicant();
        ssnUtilities = new SsnUtilities();
    }

    @Test
    public void ssnFormattingTest() {
        assertEquals("123-45-6789", ssnUtilities.formatSsn("123456789"));
    }

    @Test
    public void validSsnWithNoDashes() {
        assertEquals(0, ssnValidator.validateSsn("123456789"));
    }

    @Test
    public void ssnWithDashesInWrongPlaces() {
        assertEquals(1, ssnValidator.validateSsn("12-3456-789"));
    }

    @Test
    public void validSsnWithDashes() {
        assertEquals(0, ssnValidator.validateSsn("123-45-6789"));
    }

    @Test
    public void ssnIsTooShort() {
        assertEquals(1, ssnValidator.validateSsn("12345678"));
    }

    @Test
    public void ssnIsTooLong() {
        assertEquals(1, ssnValidator.validateSsn("1234567890"));
    }

    @Test
    public void ssnAreaNumberIs000() {
        assertEquals(2, ssnValidator.validateSsn("000223333"));
    }

    @Test
    public void ssnAreaNumberIs666() {
        assertEquals(2, ssnValidator.validateSsn("666223333"));
    }

    @Test
    public void ssnAreaNumberStartsWith9() {
        assertEquals(2, ssnValidator.validateSsn("900223333"));
    }

    @Test
    public void ssnSerialNumberIs0000() {
        assertEquals(3, ssnValidator.validateSsn("111220000"));
    }

    @Test
    public void itRejectsSsn078051120() {
        assertEquals(4, ssnValidator.validateSsn("078051120"));
    }

    @Test
    public void itRejectsSsn219099999() {
        assertEquals(4, ssnValidator.validateSsn("219099999"));
    }
}
