package com.tutorial.sultana.controllers.impl;

import com.tutorial.sultana.controllers.RestaurantController;
import com.tutorial.sultana.entities.Mans;
import com.tutorial.sultana.entities.Persons;
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
public class RestaurantControllerImpl implements RestaurantController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public ResponseEntity<?> restaurant(PostResource post) {
        Persons persons = personMapper.toPerson(post);
        mongoTemplate.save(persons);
        return ResponseEntity.ok(persons);
    }

    @Override
    public ResponseEntity<?> student(PostMan post) {
        Mans mans = new Mans();
        mans.setName(post.getName());
        mans.setClassName(post.getClassName());
        mans.setRollNumber(post.getRollNumber());
        mans.setTeacher(post.getTeacher());
        mongoTemplate.save(mans);
        return ResponseEntity.ok(mans);
    }


    @Override
    public ResponseEntity<?> getAll() {
        List<Persons> data = mongoTemplate.findAll(Persons.class);
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<?> hello() {
        return null;
    }


}
