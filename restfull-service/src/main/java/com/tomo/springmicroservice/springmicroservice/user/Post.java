package com.tomo.springmicroservice.springmicroservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @ManyToOne
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Post [id=" + id + ", description=" + description + "]";
    }
}
