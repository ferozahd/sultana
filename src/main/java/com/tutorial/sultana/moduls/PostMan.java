package com.tutorial.sultana.moduls;

import java.util.ArrayList;
import java.util.List;

public class PostMan {
    private String name;
    private List<String> teacher=new ArrayList<>();

    public List<String> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<String> teacher) {
        this.teacher = teacher;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCllass() {
        return cllass;
    }

    public void setCllass(String cllass) {
        this.cllass = cllass;
    }

    public int getRollNamber() {
        return rollNamber;
    }

    public void setRollNamber(int rollNamber) {
        this.rollNamber = rollNamber;
    }

    private String cllass;
    private int rollNamber;
}
