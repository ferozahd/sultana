package com.tutorial.sultana.repo;

import com.tutorial.sultana.entities.Persons;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonRepo extends MongoRepository<Persons, ObjectId> {

}
