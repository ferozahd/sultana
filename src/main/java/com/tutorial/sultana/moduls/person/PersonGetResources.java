package com.tutorial.sultana.moduls.person;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonGetResources {

    private String identity;
    private String name;
    private String fatherId;
    private String motherId;
    private String address;
    private String school;
    private String age;
}
