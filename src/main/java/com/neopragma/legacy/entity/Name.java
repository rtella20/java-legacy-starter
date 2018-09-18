package com.neopragma.legacy.entity;

import static com.neopragma.legacy.utils.ErrorCodes.INVALID_NAME;
import static com.neopragma.legacy.utils.ErrorCodes.SUCCESS;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String first, String middle, String last) {
        this.firstName = first == null ? "" : first;
        this.middleName = middle == null ? "" : middle;
        this.lastName = last == null ? "" : last;
    }

    public Name(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.firstName = primerNombre == null ? "" : primerNombre;
        this.middleName = segundoNombre == null ? "" : segundoNombre;
        if ( primerApellido != null ) {
            StringBuilder sb = new StringBuilder(primerApellido);
            sb.append(segundoApellido == null ? null : " " + segundoApellido);
            this.lastName = sb.toString();
        } else {
            this.lastName = "";
        }
    }

    public int validateName() {
        if ( firstName.length() > 0 && lastName.length() > 0 ) {
            return SUCCESS.value;
        } else {
            return INVALID_NAME.value;
        }
    }

    public String formatLastNameFirst() {
        StringBuilder sb = new StringBuilder(lastName);
        sb.append(", ");
        sb.append(firstName);
        if ( middleName.length() > 0 ) {
            sb.append(" ");
            sb.append(middleName);
        }
        return sb.toString();
    }

}
