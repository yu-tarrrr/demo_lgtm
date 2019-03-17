package com.example.demo.controller.resources;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sample {

    @Id
    public String name;

    public Integer age;
}
