package com.neopragma.legacy.utils;

public class SsnUtilities {

    public String formatSsn(String ssn) {
        StringBuilder sb = new StringBuilder(ssn.substring(0,3));
        sb.append("-");
        sb.append(ssn.substring(3,5));
        sb.append("-");
        sb.append(ssn.substring(5));
        return sb.toString();
    }
}
