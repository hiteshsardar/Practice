package org.com.practice.repo;

import org.com.practice.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
