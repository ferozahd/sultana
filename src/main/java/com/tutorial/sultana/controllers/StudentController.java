package com.tutorial.sultana.controllers;

import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.moduls.PostStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController  {
    @Autowired
    private MongoTemplate template;
    @PostMapping("/studentad")
    ResponseEntity<?> student(@RequestBody PostStudent post){
        Student student =new Student();
        student.setStudentName(post.getStudentName());
        student.setClassName(post.getCllassName());
        student.setRollNumber(post.getRollNamber());
        student.setHeadTeacherName(post.getHeadTeacherName());
        student.setSchoolName(post.getSchoolName());
        student.setFriends(post.getFriends());
        student.setStudentMotherName(post.getStudentMotherName());
        student.setStudentFatherName(post.getStudentFatherName());
        student.setVillageName(post.getVillageName());
        student.setPostOfficeName(post.getPostOfficeName());
        student.setPoliceStation(post.getThanaName());
        student.setDistrictName(post.getDistricName());
        student.setCountry(post.getCountry());
       template.save(student);
        return ResponseEntity.ok(student);

    }

}
