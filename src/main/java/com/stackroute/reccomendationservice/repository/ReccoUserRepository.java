package com.stackroute.reccomendationservice.repository;


import com.stackroute.reccomendationservice.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReccoUserRepository extends MongoRepository<ReccoUser, String> {

}
