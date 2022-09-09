package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.student.StudentGetResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student/")
public interface StudentController {
    @PostMapping("create")
    ResponseEntity<StudentGetResources> create(@RequestBody StudentGetResources post);

    @GetMapping("getAll")
    ResponseEntity<List<StudentGetResources>> getAll();

    @GetMapping("getOne/{id}")
    ResponseEntity<StudentGetResources> getOne(@PathVariable String id);
}


