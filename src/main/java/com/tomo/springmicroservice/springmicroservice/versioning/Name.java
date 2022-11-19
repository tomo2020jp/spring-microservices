package com.tomo.springmicroservice.springmicroservice.versioning;

import lombok.Getter;

@Getter
public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name [firstName" + firstName + ", lastName=" + lastName + "]";
    }
}
