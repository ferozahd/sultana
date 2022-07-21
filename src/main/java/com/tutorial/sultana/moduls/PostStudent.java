package com.tutorial.sultana.moduls;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

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
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getStudentMotherName() {
        return studentMotherName;
    }

    public void setStudentMotherName(String studentMotherName) {
        this.studentMotherName = studentMotherName;
    }

    public String getStudentFatherName() {
        return studentFatherName;
    }

    public void setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getPostOfficeName() {
        return postOfficeName;
    }

    public void setPostOfficeName(String postOfficeName) {
        this.postOfficeName = postOfficeName;
    }

    public String getThanaName() {
        return thanaName;
    }

    public void setThanaName(String thanaName) {
        this.thanaName = thanaName;
    }

    public String getDistricName() {
        return districName;
    }

    public void setDistricName(String districName) {
        this.districName = districName;
    }



    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCllassName() {
        return cllassName;
    }

    public void setCllassName(String cllassName) {
        this.cllassName = cllassName;
    }

    public int getRollNamber() {
        return rollNamber;
    }

    public void setRollNamber(int rollNamber) {
        this.rollNamber = rollNamber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getHeadTeacherName() {
        return headTeacherName;
    }

    public void setHeadTeacherName(String headTeacherName) {
        this.headTeacherName = headTeacherName;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
