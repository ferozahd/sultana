package com.tutorial.sultana.moduls;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PostStudent {
    private ObjectId id;
    private String studentName;
    private String cllassName;
    private int rollNamber;
    private String schoolName;
    private String headTeacherName;
    private List<String> friends=new ArrayList<>();
    private String studentMotherName;
    private String studentFatherName;
    private String villageName;
    private String postOfficeName;
    private String thanaName;
    private String districName;
    private String country;

}
