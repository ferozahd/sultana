package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.PersonGetResources;
import com.tutorial.sultana.moduls.PostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonController {


    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody PostResource post);


    @GetMapping("/getAll")
    ResponseEntity<?> getAll();


    @GetMapping("/getOne")
    ResponseEntity<PersonGetResources> getOne();
}
