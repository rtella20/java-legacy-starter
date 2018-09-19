package com.neopragma.legacy.utils;

import java.io.IOException; /**
 * Unchecked exception to wrap the IOException and URISyntaxException in city state lookup service
 *
 * @author neopragma
 * @version 1.0
 */
public class CityStateLookupException extends RuntimeException {
    private static final long serialVersionUID = 9090909090909090L;
    private Throwable lookupException;

    public CityStateLookupException(Throwable exception) {
        this.lookupException = exception;
    }

    public CityStateLookupException(String message, Throwable exception) {
        super(message, exception);
    }

    public Throwable getLookupException() {
        return lookupException;
    }
}
