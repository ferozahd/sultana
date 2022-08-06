package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.student.StudentGetResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentController {
    @PostMapping("/student/create")
    ResponseEntity<StudentGetResources> create(@RequestBody StudentGetResources post);

    @GetMapping("student/getAll")
    ResponseEntity<List<StudentGetResources>> getAll();

    @GetMapping("student/getOne/{id}")
    ResponseEntity<StudentGetResources> getOne(@PathVariable String id);
}


