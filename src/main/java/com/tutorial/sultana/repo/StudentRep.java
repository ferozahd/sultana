package com.tutorial.sultana.repo;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.entities.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRep extends MongoRepository <Student, ObjectId> {
    List<Student> findAll();
}
