package com.example.accessingdatamysql.securityjwt.services;

import com.example.accessingdatamysql.UserRepository;
import com.example.accessingdatamysql.DrinkEetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

//USER DETAIL SERVICE
@Service
public class MyUDS implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private User spring_user;

    private DrinkEetUser drinkEetUser;

    String username_string;
    String password_string;

    //TODO load user from database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return new User("naam", "wachtwoord", new ArrayList<>());
    }

}