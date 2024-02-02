package com.pragra.learning.estore.repositories;

import com.pragra.learning.estore.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findUserByUsername(String username);
    Optional<Users> findUserByFirstName(String firstName);
}
