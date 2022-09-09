package com.tutorial.sultana.service.impl;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.exceptions.ResourceNotFoundException;
import com.tutorial.sultana.mapper.PersonMapper;
import com.tutorial.sultana.moduls.person.PersonDetailsResponse;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import com.tutorial.sultana.repo.PersonRepo;
import com.tutorial.sultana.service.PersonService;
import com.tutorial.sultana.utils.VariableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonRepo personRepo;

    private final MongoTemplate mongoTemplate;
    /*
     * this part we just featch all data from person collection
     * and We will parse it to @class PersonGetResourece
     * */

    @Override
    public Page<PersonGetResources> findAll(int index) {
        index = index < 0 ? 0 : index;
        PageRequest adf = PageRequest.of(index, 5);
        return personRepo.findAll(adf).map(personMapper::toGetResource);
    }

    @Override
    public PersonDetailsResponse getOne(String id) {
        Persons persons = personRepo.findById(VariableUtils.toObjectId(id))
                .orElseThrow(() -> new ResourceNotFoundException("this is id not available"));

        PersonDetailsResponse response = personMapper.toDetailsResponse(persons);


        if (persons.getFatherId() != null) {
            Persons father = personRepo.findById(VariableUtils.toObjectId(persons.getFatherId()))
                    .orElseThrow(() -> new ResourceNotFoundException("this is id not available"));
            PersonDetailsResponse fatherResponse = personMapper.toDetailsResponse(father);
            response.setFather(fatherResponse);

        }

        if (persons.getMotherId() != null) {
            Persons mother = personRepo.findById(VariableUtils.toObjectId(persons.getMotherId()))
                    .orElseThrow(() -> new ResourceNotFoundException("this is id not available"));
            PersonDetailsResponse motherResponse = personMapper.toDetailsResponse(mother);
            response.setMother(motherResponse);

        }

        List<PersonDetailsResponse> siblings = new ArrayList<>();
        persons.getSiblings().forEach(sibling -> {
            Persons sb = personRepo.findById(VariableUtils.toObjectId(sibling)).get();
            siblings.add(personMapper.toDetailsResponse(sb));
        });

        response.setSiblings(siblings);

        return response;
    }


    @Override
    public PersonGetResources create(PostResource post) {
        Persons persons = personMapper.toPerson(post);
        personRepo.save(persons);
        return personMapper.toGetResource(persons);
    }

    @Override
    public PersonGetResources setFather(String fatherId, String personId) {
        personRepo.findById(VariableUtils.toObjectId(fatherId))
                .orElseThrow(() -> new ResourceNotFoundException("Father not found"));

        Persons person = personRepo.findById(VariableUtils.toObjectId(personId))
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        person.setFatherId(fatherId);
        personRepo.save(person);
        return personMapper.toGetResource(person);
    }

    @Override
    public PersonGetResources setMother(String motherId, String personId) {
        personRepo.findById(VariableUtils.toObjectId(motherId))
                .orElseThrow(() -> new ResourceNotFoundException("mother not found"));

        Persons person = personRepo.findById(VariableUtils.toObjectId(personId))
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        person.setMotherId(motherId);
        personRepo.save(person);
        return personMapper.toGetResource(person);

    }

    @Override
    public PersonGetResources setSibling(String siblingId, String personId) {

        personRepo.findById(VariableUtils.toObjectId(siblingId))
                .orElseThrow(() -> new ResourceNotFoundException("Siblings not available"));
        Persons persons = personRepo.findById(VariableUtils.toObjectId(personId))
                .orElseThrow(() -> new ResourceNotFoundException("Person not available"));

        List<String> siblings = persons.getSiblings();
        siblings.add(siblingId);
        persons.setSiblings(siblings);
        persons = personRepo.save(persons);

        return personMapper.toGetResource(persons);
    }
}

