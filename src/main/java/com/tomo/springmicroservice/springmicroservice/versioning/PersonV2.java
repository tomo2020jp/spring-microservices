package com.tomo.springmicroservice.springmicroservice.versioning;

import lombok.Getter;

@Getter
public class PersonV2 {
    private final Name name;

    public PersonV2(Name name){
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV2 [name=" + name + "]";
    }
}
