package com.ulises.notificationsserver.services.repositories;

import com.ulises.notificationsserver.services.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
