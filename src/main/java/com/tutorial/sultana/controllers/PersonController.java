package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonController {

    @PostMapping("person/create")
    ResponseEntity<PersonGetResources> create(@RequestBody PostResource post);


    @GetMapping("person/getAll")
    ResponseEntity<List<PersonGetResources>> getAll();


    @GetMapping("person/getOne/{id}")
    ResponseEntity<PersonGetResources> getOne(@PathVariable("id") String id);

}
