package com.tomo.springmicroservice.springmicroservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

//@JsonIgnoreProperties({"field1","field2"})
@JsonFilter("SomeBeanFilter")
@Getter
public class SomeBean {

    private final String field1;
    private final String field2;
    private final String field3;

    public SomeBean(String field1, String field2, String field3){
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }
}
