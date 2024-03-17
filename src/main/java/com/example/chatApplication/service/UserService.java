package com.example.chatApplication.service;

import com.example.chatApplication.Repo.UserRepo;
import com.example.chatApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;
void addUser(User user){
    userRepo.save(user);
}
void deleteUser(Long id){
    userRepo.deleteById(id);
}
void updateUser(Long id){
    userRepo.deleteById(id);
}
List<User> findAllUsers(){
    return userRepo.findAll();
}
Optional<User> findUsersById(Long id){
    return userRepo.findById(id);
}
Optional<List<User>> findUserByUserName(String UserName){
    return userRepo.findUserByName(UserName);
}
}
