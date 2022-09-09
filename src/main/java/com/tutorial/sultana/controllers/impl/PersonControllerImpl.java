package com.tutorial.sultana.controllers.impl;

import com.tutorial.sultana.controllers.PersonController;
import com.tutorial.sultana.moduls.person.PersonDetailsResponse;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import com.tutorial.sultana.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;


    @Override
    public ResponseEntity<Page<PersonGetResources>> getAll(int index) {
        return ResponseEntity.ok(personService.findAll(index));
    }

    @Override
    public ResponseEntity<PersonDetailsResponse> getOne(String id) {
        return ResponseEntity.ok(personService.getOne(id));
    }

    @Override
    public ResponseEntity<PersonGetResources> setFather(String fatherId, String personId) {
        return ResponseEntity.ok(personService.setFather(fatherId,  personId));
    }

    @Override
    public ResponseEntity<PersonGetResources> setMother(String motherId, String personId) {
        return ResponseEntity.ok(personService.setMother(motherId,  personId));
    }

    @Override
    public ResponseEntity<PersonGetResources> setSibling(String siblingId, String personId) {
        return ResponseEntity.ok(personService.setSibling(siblingId,  personId));
    }


    @Override
    public ResponseEntity<PersonGetResources> create(PostResource post) {
        return ResponseEntity.ok(personService.create(post));
    }


}
