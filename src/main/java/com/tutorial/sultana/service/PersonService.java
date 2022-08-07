package com.tutorial.sultana.service;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;

import java.util.List;

public interface PersonService {
    List<PersonGetResources> findAll();

    PersonGetResources getOne(String id);

    PersonGetResources create(PostResource post);
}
