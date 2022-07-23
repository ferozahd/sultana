package com.tutorial.sultana.controllers;

import com.tutorial.sultana.entities.Mans;
import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.mapper.MansMapper;
import com.tutorial.sultana.mapper.PersonMapper;
import com.tutorial.sultana.moduls.PostMan;
import com.tutorial.sultana.moduls.PostResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResturentController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private MansMapper mansMapper;

    @PostMapping("/persons")
    ResponseEntity<?> resturent(@RequestBody PostResource post) {

        Persons persons = personMapper.toPerson(post);
        mongoTemplate.save(persons);

        return ResponseEntity.ok(persons);
    }

    @PostMapping("/mans")
    ResponseEntity<?> mans(@RequestBody PostMan post) {
        Mans mans = mansMapper.toMans(post);
        mongoTemplate.save(mans);
        return ResponseEntity.ok(mans);
    }


    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        List<Persons> data = mongoTemplate.findAll(Persons.class);
        return ResponseEntity.ok(data);
    }
}
