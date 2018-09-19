package com.neopragma.legacy.utils;

/**
 * Contains error messages for CityStateException
 *
 * @author neopragma
 * @version 1.0.0
 */

public enum ErrorMessages {

    FAILED_TO_MAKE_REMOTE_CALL("Failed to make remote call"),
    FAILED_TO_BUILD_URI("Failed to build URI"),
    UNABLE_TO_CLOSE_HTTP_RESPONSE("Unable to close http response");

    public String value;
    ErrorMessages(String val) { this.value = val;}
}
