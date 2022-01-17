package com.combs.dashboard.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<List<User>> getUsers(){
        try{
            return new ResponseEntity<>(new ArrayList<>(userRepository.findAll()), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> addUser(User user) {
        try {
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> removeUser(String userId) {
        try {
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> updateUser(User user) {

        Optional<User> userCurrent = userRepository.findById(user.getUserId());

        if(userCurrent.isPresent()){
            try {
                User userNew = userCurrent.get();
                userNew.setFirstName(user.getFirstName());
                
                userNew.setLastName(user.getLastName());
                userNew.setBirthdate(user.getBirthdate());
                userNew.setImageUrl(user.getImageUrl());
                return new ResponseEntity<>(userRepository.save(userNew), HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
