package com.tomo.springmicroservice.springmicroservice.user;

import lombok.Data;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Data
public class User {

    private Integer id;
    @Size(min=2,message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "Birth Date should be in the past")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }
}
