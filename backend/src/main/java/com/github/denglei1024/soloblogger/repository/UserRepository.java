package com.github.denglei1024.soloblogger.repository;

import com.github.denglei1024.soloblogger.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserRepository
 *
 * @author denglei
 * @since 2024-05-31 17:58
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}