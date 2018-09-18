package com.neopragma.legacy.utils;

public class SsnUtilities {

    private String[] specialCases = new String[] {
            "219099999", "078051120"
    };


    public String formatSsn(String ssn) {
        StringBuilder sb = new StringBuilder(ssn.substring(0,3));
        sb.append("-");
        sb.append(ssn.substring(3,5));
        sb.append("-");
        sb.append(ssn.substring(5));
        return sb.toString();
    }

    public int validateSsn(String ssn) {
        if ( !ssn.matches("\\d{9}") ) {
            return 1;
        }
        if ( "000".equals(ssn.substring(0,3)) ||
                "666".equals(ssn.substring(0,3)) ||
                "9".equals(ssn.substring(0,1)) ) {
            return 2;
        }
        if ( "0000".equals(ssn.substring(5)) ) {
            return 3;
        }
        for (int i = 0 ; i < specialCases.length ; i++ ) {
            if ( ssn.equals(specialCases[i]) ) {
                return 4;
            }
        }
        return 0;
    }

}
