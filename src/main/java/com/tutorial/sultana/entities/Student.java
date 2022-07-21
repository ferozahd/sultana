package com.tutorial.sultana.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Document(collection = "student")
public class Student {
    private ObjectId id;
    private String studentName;
    private String className;
    private int rollNumber;
    private String schoolName;
    private String headTeacherName;
    private List<String> friends=new ArrayList<>();
    private String studentMotherName;
    private String studentFatherName;
    private String villageName;
    private String postOfficeName;
    private String policeStation ;
    private String districtName;
    private String country;

}
