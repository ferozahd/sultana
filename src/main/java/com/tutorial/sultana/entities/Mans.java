package com.tutorial.sultana.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection= "mans")
public class Mans {
    @Id
    private ObjectId Id;
    private String name;
    private String cllass;
    private int rollNamber;
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



    public ObjectId getId() {
        return Id;
    }

    public void setId(ObjectId id) {
        Id = id;
    }
}
