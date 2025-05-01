package com.study.nosql.services;

import com.study.nosql.domain.User;
import com.study.nosql.exceptions.UserNotFoundException;
import com.study.nosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User com " + id + "não encontrado"));
    }
}
