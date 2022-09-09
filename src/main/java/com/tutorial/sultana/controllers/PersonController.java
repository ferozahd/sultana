package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.person.PersonDetailsResponse;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("person/")
public interface PersonController {

    @PostMapping("create")
    ResponseEntity<PersonGetResources> create(@RequestBody PostResource post);


    @GetMapping("getAll/{index}")
    ResponseEntity<Page<PersonGetResources>> getAll(@PathVariable int index);


    @GetMapping("getOne/{id}")
    ResponseEntity<PersonDetailsResponse> getOne(@PathVariable("id") String id);

    @PatchMapping("set-father/{fatherId}/{personId}")
    ResponseEntity<PersonGetResources> setFather(@PathVariable String fatherId, @PathVariable String personId);


    @PatchMapping("set-mother/{motherId}/{personId}")
    ResponseEntity<PersonGetResources> setMother(@PathVariable String motherId, @PathVariable String personId);

    @PatchMapping("set-siblings/{siblingId}/{personId}")
    ResponseEntity<PersonGetResources> setSibling(@PathVariable String siblingId, @PathVariable String personId);
}
