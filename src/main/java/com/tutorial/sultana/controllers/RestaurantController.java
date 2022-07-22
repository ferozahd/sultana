package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.PostMan;
import com.tutorial.sultana.moduls.PostResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RestaurantController {

    @GetMapping("/hello")
    public ResponseEntity<?> hello();

    @PostMapping("/restaurant")
    ResponseEntity<?> restaurant(@RequestBody PostResource post);

    @PostMapping("/student")
    ResponseEntity<?> student(@RequestBody PostMan post);

    @GetMapping("/getAll")
    ResponseEntity<?> getAll();
}
