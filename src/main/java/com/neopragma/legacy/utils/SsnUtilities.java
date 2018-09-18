package com.neopragma.legacy.utils;

import static com.neopragma.legacy.utils.ErrorCodes.*;
/**
 * Utility service to format and validate SSN
 *
 * @author neopragma
 * @version 1.0.0
 */
public class SsnUtilities {

    public static final String SSN_NON_ALLOCATED_SERIES_000 = "000";
    public static final String SSN_NON_ALLOCATED_SERIES_666 = "666";
    public static final String SSN_NON_ALLOCATED_SERIES_9 = "9";
    public static final String SSN_ZERO_DIGITS = "0000";

    public static final String SSN_SCPECIAL_CASE_1 = "219099999";
    public static final String SSN_SPECIAL_CASE_2 = "078051120";

    private String[] specialCases = new String[] {
            SSN_SCPECIAL_CASE_1, SSN_SPECIAL_CASE_2
    };

    public String removeHyphens(String ssn) {
        String nonHyphenSsn = "";
        if ( ssn.matches("(\\d{3}-\\d{2}-\\d{4}|\\d{9})") ) {
            nonHyphenSsn = ssn.replaceAll("-", "");
        }
        return nonHyphenSsn;
    }

    public String formatSsn(String ssn) {
        StringBuilder sb = new StringBuilder(ssn.substring(0,3));
        sb.append("-");
        sb.append(ssn.substring(3,5));
        sb.append("-");
        sb.append(ssn.substring(5));
        return sb.toString();
    }

    public int validateSsn(String ssnForValiation) {
        String ssn = removeHyphens(ssnForValiation);
        if ( !ssn.matches("\\d{9}") ) {
            return SSN_INVALID_LENGTH.value;
        }
        if ( SSN_NON_ALLOCATED_SERIES_000.equals(ssn.substring(0,3)) ||
                SSN_NON_ALLOCATED_SERIES_666.equals(ssn.substring(0,3)) ||
                SSN_NON_ALLOCATED_SERIES_9.equals(ssn.substring(0,1)) ) {
            return SSN_NON_ALLOCATED_PREFIX.value;
        }
        if ( SSN_ZERO_DIGITS.equals(ssn.substring(5)) ) {
            return SSN_HAS_ZERO_DIGITS.value;
        }
        for (int i = 0 ; i < specialCases.length ; i++ ) {
            if ( ssn.equals(specialCases[i]) ) {
                return SSN_SPECIAL_CASE.value;
            }
        }
        return SUCCESS.value;
    }

}
