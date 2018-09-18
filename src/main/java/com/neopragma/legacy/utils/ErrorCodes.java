package com.neopragma.legacy.utils;

public enum ErrorCodes {

    SSN_INVALID_LENGTH(1),
    SSN_NON_ALLOCATED_PREFIX(2),
    SSN_HAS_ZERO_DIGITS(3),
    SSN_SPECIAL_CASE(4),
    SUCCESS(0);

    public Integer value;
    ErrorCodes(Integer val) { this.value = val;}
}
