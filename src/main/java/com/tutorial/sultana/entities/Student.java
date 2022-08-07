package com.tutorial.sultana.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "st")
@Getter
@Setter
public class Student {
    @Id
    private ObjectId id;
    private String name;
    private String address;
    private String school;
    private  int age ;
    private int roll;


    public static Student get() {
        return null;
    }
}
