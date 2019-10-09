package com.caseStudy.eCart.service;


import com.caseStudy.eCart.model.Users;
import com.caseStudy.eCart.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Users addUser(Users user) { return usersRepository.save(user); }
}
