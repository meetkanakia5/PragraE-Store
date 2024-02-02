package com.pragra.learning.estore.service;

import com.pragra.learning.estore.entities.Address;
import com.pragra.learning.estore.entities.Users;
import com.pragra.learning.estore.repositories.AddressRepository;
import com.pragra.learning.estore.repositories.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserService {
    public final UserRepository userRepository;
    public final AddressRepository addressRepository;

    public Users addUser(Users users) {
        Address address = addressRepository.save(users.getAddress());
        users.setAddress(address);
        return userRepository.save(users);
    }
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<Users> getUserById(Integer userId) {
        // Retrieving a user from the database by ID using the UserRepository
        Users user = userRepository.findById(userId).get();
        return Optional.of(user);
    }
    public Optional<Users> getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
    public Optional<Users> getUserByFirstName(String firstName){
        return userRepository.findUserByFirstName(firstName);
    }
    public Optional<Users> updateUser(Users users){
        Optional<Users> optionalUserById = getUserById(users.getUserId());
        if (optionalUserById.isPresent()){
            return Optional.of(addUser(users));
        }
        return Optional.empty();
    }
    public Optional<Users> deleteUserById(Integer userId){
        Optional<Users> optionalUserById = getUserById(userId);
        if (optionalUserById.isPresent()){
            userRepository.deleteById(userId);
            return optionalUserById;
        }
        return Optional.empty();
    }
}
