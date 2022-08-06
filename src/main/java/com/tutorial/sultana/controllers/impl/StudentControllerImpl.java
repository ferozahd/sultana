package com.tutorial.sultana.controllers.impl;


import com.tutorial.sultana.controllers.StudentController;
import com.tutorial.sultana.moduls.student.StudentGetResources;
import com.tutorial.sultana.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentControllerImpl implements StudentController {
    private final StudentService studentService;



    @Override
    public ResponseEntity<StudentGetResources> create(StudentGetResources post) {
        return ResponseEntity.ok(studentService.create(post));
    }

    @Override

    public ResponseEntity<List<StudentGetResources>> getAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @Override
    public ResponseEntity<StudentGetResources> getOne(String id) {
        return ResponseEntity.ok(studentService.getOne(id));
    }


}
