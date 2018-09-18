package com.neopragma.legacy.screen;

import com.neopragma.legacy.entity.JobApplicant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Automated unit checks for the Name class.
 * Checks of various formatting patterns and validations.
 *
 * @author neopragma
 * @version 1.0.0
 */
public class NameTest {
    private JobApplicant jobApplicant;

    @Before
    public void beforeEach() {
        jobApplicant = new JobApplicant();
    }

    @Test
    public void completeNameProvided() {
        Name name = new Name ("First", "Middle", "Last");
        assertEquals(0, name.validateName());
    }

    @Test
    public void firstAndLastNamesProvided() {
        jobApplicant.setName("First", null, "Last");
        assertEquals(0, jobApplicant.validateName());
    }

    @Test
    public void missingFirstName() {
        jobApplicant.setName(null, null, "Last");
        assertEquals(6, jobApplicant.validateName());
    }

    @Test
    public void missingLastName() {
        jobApplicant.setName("First", null, null);
        assertEquals(6, jobApplicant.validateName());
    }

    @Test
    public void completeSpanishNameProvided() {
        jobApplicant.setSpanishName("PrimerNombre", "SegundoNombre", "PrimerApellido", "SegundoApellido");
        assertEquals(0, jobApplicant.validateName());
    }

    @Test
    public void spanishNameWithOneFirstNameProvided() {
        jobApplicant.setSpanishName("PrimerNombre", null, "PrimerApellido", "SegundoApellido");
        assertEquals(0, jobApplicant.validateName());
    }

    @Test
    public void spanishNameWithOneLastNameProvided() {
        jobApplicant.setSpanishName("PrimerNombre", null, "PrimerApellido", null);
        assertEquals(0, jobApplicant.validateName());
    }

    @Test
    public void spanishNameWithNoFirstNameProvided() {
        jobApplicant.setSpanishName(null, null, "PrimerApellido", null);
        assertEquals(6, jobApplicant.validateName());
    }

    @Test
    public void spanishNameWithNoLastNameProvided() {
        jobApplicant.setSpanishName("PrimerNombre", "SegundoNombre", null, null);
        assertEquals(6, jobApplicant.validateName());
    }

    @Test
    public void formatEnglishNameLastNameFirst() {
        jobApplicant.setName("First", "Middle", "Last");
        assertEquals("Last, First Middle", jobApplicant.formatLastNameFirst());
    }

}
