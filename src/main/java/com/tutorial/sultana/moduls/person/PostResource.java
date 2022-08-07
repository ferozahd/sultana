package com.tutorial.sultana.moduls.person;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PostResource {
    private String name;
    private String fatherName;
    private String motherName;
    private int age;
    private String address;
    private List<String> friends;
}