package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.PersonGetResources;
import com.tutorial.sultana.moduls.PostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;

public interface PersonController {


    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody PostResource post);


    @GetMapping("/getAll")
    ResponseEntity<?> getAll();


    @GetMapping("/getOne/{id}")
    ResponseEntity<PersonGetResources> getOne(@PathVariable("id") String id);
}
