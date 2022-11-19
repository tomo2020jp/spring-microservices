package com.tomo.springmicroservice.springmicroservice.versioning;

import lombok.Getter;

@Getter
public class PersonV1 {
    private final String name;

    public PersonV1(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV1 [name=" + name + "]";
    }
}
