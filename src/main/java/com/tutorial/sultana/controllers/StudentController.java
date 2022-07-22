package com.tutorial.sultana.controllers;

import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.mapper.StudentMapper;
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
    @Autowired
    private StudentMapper studentMapper;
    @PostMapping("/studentad")
    ResponseEntity<?> student(@RequestBody PostStudent post){
        Student student =studentMapper.toStudent(post);
       template.save(student);
        return ResponseEntity.ok(student);

    }

}
