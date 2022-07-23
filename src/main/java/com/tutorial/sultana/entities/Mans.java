package com.tutorial.sultana.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Document(collection= "mans")
public class Mans {
    @Id
    private ObjectId Id;
    private String name;
    private String className;
    private int rollNumber;
    private List<String> teachers=new ArrayList<>();
    private String headTeachername;

}
