package com.tutorial.sultana.service;

import com.tutorial.sultana.moduls.student.StudentGetResources;

import java.util.List;

public interface StudentService {
    StudentGetResources create(StudentGetResources post);

    List<StudentGetResources> findAll();

    StudentGetResources getOne(String id);
}
