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
public class StudentController {
    @Autowired
    private MongoTemplate template;
    @PostMapping("/studentad")
    ResponseEntity<?> student(@RequestBody PostStudent post){
        Student student =new Student();
        student.setStudentName(post.getStudentName());
        student.setCllassName(post.getCllassName());
        student.setRollNamber(post.getRollNamber());
        student.setHeadTeacherName(post.getHeadTeacherName());
        student.setSchoolName(post.getSchoolName());
        student.setFriends(post.getFriends());
        student.setStudentMotherName(post.getStudentMotherName());
        student.setStudentFatherName(post.getStudentFatherName());
        student.setVillageName(post.getVillageName());
        student.setPostOfficeName(post.getPostOfficeName());
        student.setThanaName(post.getThanaName());
        student.setDistricName(post.getDistricName());
       template.save(student);
        return ResponseEntity.ok(student);

    }
}
