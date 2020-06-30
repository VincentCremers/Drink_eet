package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface UserRepository extends CrudRepository<DrinkEetUser, Integer> {

    DrinkEetUser findByEmail(@Param("email") String email);
    String findByPassword(@Param("password") String password);
}
