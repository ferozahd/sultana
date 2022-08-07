package com.tutorial.sultana.moduls.student;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentGetResources {
    private String name;
    private String address;
    private String school;
    private  int age ;
    private int roll;

    public void setId(String toHexString) {
    }
}
