package com.example.demo.repository;

import com.example.demo.model.PersonMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoDBRepository extends MongoRepository<PersonMongoDB, String> {
}
