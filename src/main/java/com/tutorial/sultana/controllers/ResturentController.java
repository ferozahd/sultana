package com.tutorial.sultana.controllers;

import com.tutorial.sultana.entities.Mans;
import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.mapper.PersonMapper;
import com.tutorial.sultana.moduls.PostMan;
import com.tutorial.sultana.moduls.PostResource;
import com.tutorial.sultana.moduls.PostStudent;
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



  @PostMapping("/restaurant")
    ResponseEntity<?> resturent(@RequestBody PostResource post){

      Persons persons =personMapper.toPerson(post);
    mongoTemplate.save(persons);

    return ResponseEntity.ok(persons);
  }
@PostMapping("/student")
ResponseEntity<?> student(@RequestBody PostMan post){
    Mans mans=new Mans();
    mans.setName(post.getName());
    mans.setCllass(post.getCllass());
    mans.setRollNamber(post.getRollNamber());
    mans.setTeacher(post.getTeacher());
    mongoTemplate.save(mans);
    return ResponseEntity.ok(mans);
}



  @GetMapping("/getAll")
  ResponseEntity<?> getAll(){
    List<Persons> data = mongoTemplate.findAll(Persons.class);
    return ResponseEntity.ok(data);
  }
}
