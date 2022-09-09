package com.tutorial.sultana.moduls.person;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDetailsResponse {
    private String identity;
    private String name;
    private PersonDetailsResponse father;
    private PersonDetailsResponse mother;
    private String address;
    private String school;
    private String age;
    private List<PersonDetailsResponse> siblings;
}
