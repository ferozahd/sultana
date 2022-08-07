package com.tutorial.sultana.controllers.impl;

import com.tutorial.sultana.controllers.PersonController;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import com.tutorial.sultana.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;


    @Override
    public ResponseEntity<List<PersonGetResources>> getAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @Override
    public ResponseEntity<PersonGetResources> getOne(String id) {
        return ResponseEntity.ok(personService.getOne(id));
    }

    @Override
    public ResponseEntity<PersonGetResources> create(PostResource post) {
        return ResponseEntity.ok(personService.create(post));
    }


}
