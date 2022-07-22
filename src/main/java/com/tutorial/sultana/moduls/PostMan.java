package com.tutorial.sultana.moduls;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PostMan {

    private String name;
    private String className;
    private int rollNumber;
    private List<String> teacher=new ArrayList<>();
}
