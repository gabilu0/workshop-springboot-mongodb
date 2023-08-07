package com.gabilu.workshopmongo.services;

import com.gabilu.workshopmongo.domain.User;
import com.gabilu.workshopmongo.repository.UserRepository;
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
}
