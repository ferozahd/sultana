package com.tutorial.sultana.controllers.impl;

import com.tutorial.sultana.controllers.PersonController;
import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.exceptions.DateNotFoundException;
import com.tutorial.sultana.exceptions.InvalidConversion;
import com.tutorial.sultana.mapper.PersonMapper;
import com.tutorial.sultana.moduls.PersonGetResources;
import com.tutorial.sultana.moduls.PostResource;
import com.tutorial.sultana.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInput;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {
    private final MongoTemplate mongoTemplate;

    private final PersonMapper personMapper;
    private final PersonRepo personRepo;


    @Override
    public ResponseEntity<?> getAll() {
        List<Persons> data = mongoTemplate.findAll(Persons.class);
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<PersonGetResources> getOne(String id) {
//        Persons persons =mongoTemplate.findOne(
//                Query.query(
//                        Criteria.where("id").is(new ObjectId("62de42ba5cdfa50e9759e992"))
//                ),
//                Persons.class
//        );
        ObjectId newId = null;
        try {
            newId = new ObjectId(id);
        } catch (Exception e) {
            throw new InvalidConversion("This is not Hexanumber");
        }

        Optional<Persons> persons = personRepo.findById(newId);

        if(persons.isPresent()){
            PersonGetResources response = personMapper.toGetResource(persons.get());
            response.setId(persons.get().getId().toHexString());
            return ResponseEntity.ok(response);
        }
        throw new DateNotFoundException("Person not available in this id ");

    }


    @Override
    public ResponseEntity<?> create(PostResource post) {
        Persons persons = personMapper.toPerson(post);
        personRepo.save(persons);
        PersonGetResources response = personMapper.toGetResource(persons);
        response.setId(persons.getId().toHexString());
        return ResponseEntity.ok(response);
    }


}
