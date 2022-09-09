package com.tutorial.sultana.repo;

import com.tutorial.sultana.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Object> {
    Optional<User> findByUserName(String username);

    long countByUserName(String username);

    long countByEmail(String username);
}
