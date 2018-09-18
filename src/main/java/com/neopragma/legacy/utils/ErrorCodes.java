package com.neopragma.legacy.utils;

/**
 * Contains validation and formatting error codes for ssn and name
 *
 * @author neopragma
 * @version 1.0.0
 */

public enum ErrorCodes {

    SSN_INVALID_LENGTH(1),
    SSN_NON_ALLOCATED_PREFIX(2),
    SSN_HAS_ZERO_DIGITS(3),
    SSN_SPECIAL_CASE(4),
    SUCCESS(0),
    INVALID_NAME(6);

    public Integer value;
    ErrorCodes(Integer val) { this.value = val;}
}
