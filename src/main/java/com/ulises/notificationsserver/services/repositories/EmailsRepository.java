package com.ulises.notificationsserver.services.repositories;

import com.ulises.notificationsserver.services.entities.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailsRepository extends MongoRepository<Email, String> {}