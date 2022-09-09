package com.tutorial.sultana.service;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.moduls.person.PersonDetailsResponse;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {
    Page<PersonGetResources> findAll(int index);

    PersonDetailsResponse getOne(String id);

    PersonGetResources create(PostResource post);

    PersonGetResources setFather(String fatherId, String personId);

   PersonGetResources setMother(String motherId, String personId);

    PersonGetResources setSibling(String siblingId, String personId);
}
