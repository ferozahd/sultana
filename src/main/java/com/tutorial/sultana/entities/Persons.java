package com.tutorial.sultana.entities;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "persons")
public class Persons {
    @Id
    private ObjectId id;
    private String name;
    private String fatherId;
    private String motherId;
    private int age;
    private String address;
    private String school;
    private List<String> siblings = new ArrayList<>();

}
