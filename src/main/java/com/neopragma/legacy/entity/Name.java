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
            return 0;
        } else {
            return 6;
        }
    }
}
