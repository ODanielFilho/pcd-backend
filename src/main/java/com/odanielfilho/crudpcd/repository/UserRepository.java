package com.odanielfilho.crudpcd.repository;


import com.odanielfilho.crudpcd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
