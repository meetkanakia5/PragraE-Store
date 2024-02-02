package com.pragra.learning.estore.controller;

import com.pragra.learning.estore.entities.Users;
import com.pragra.learning.estore.service.UserService;
import org.apache.catalina.User;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    /*public Users addUser(@RequestBody Users users){
     return userService.addUser(users);
    }*/
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Users addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Users> getAll(){
        return userService.getAllUser();
    }
    @GetMapping("/all/{userId}")
    public Optional<Users> getByUserId(@PathVariable ("userId") Integer userId){
        return userService.getUserById(userId);
    }
    @GetMapping("/allByUsername/{username}")
    public Optional<Users> getUserByUserName(@PathVariable ("username") String username){
        return userService.getUserByUsername(username);
    }
    @GetMapping("/allByFirstName/{firstName}")
    public Optional<Users> getUserByFirstName(@PathVariable ("firstName") String firstName){
        return userService.getUserByFirstName(firstName);
    }
   /* @PutMapping("/update")
    public Optional<Users> updateUser(@RequestBody Users users) {
        return userService.updateUser(users);
    }*/
    @PostMapping("/update")
    public ResponseEntity<Users> updateUser(@RequestBody Users users) {
        ResponseEntity<Users> usersResponseEntity;
        Optional<Users> updatedUser = userService.updateUser(users);
        if (updatedUser.isPresent()) {
            usersResponseEntity = ResponseEntity.ok(users);
        } else {
            usersResponseEntity = ResponseEntity.noContent().header("error message", "Employee not found for id: "+ users.getUserId()).build();
        }
        return usersResponseEntity;
    }
    @DeleteMapping("/delete/{userId}")
    public Optional<Users> deleteUser(@PathVariable ("userId") Integer userId){
        return userService.deleteUserById(userId);
    }

}
