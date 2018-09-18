package com.neopragma.legacy.entity;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String first, String middle, String last) {
        this.firstName = first == null ? "" : first;
        this.middleName = middle == null ? "" : middle;
        this.lastName = last == null ? "" : last;
    }

    public int validateName() {
        if ( firstName.length() > 0 && lastName.length() > 0 ) {
            return 0;
        } else {
            return 6;
        }
    }
}
