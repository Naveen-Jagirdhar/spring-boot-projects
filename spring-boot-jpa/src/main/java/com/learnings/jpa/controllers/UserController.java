package com.learnings.jpa.controllers;

import com.learnings.jpa.entity.Users;
import com.learnings.jpa.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUsersRepository repository;

    @PostMapping
    public ResponseEntity<?> createUsers(@RequestBody Users users) {

        repository.save(users);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUsers(@RequestParam("userId") Long userId) {

        Optional<Users> users = repository.findById(userId);
        Users users1 = users.get();
        repository.delete(users1);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
