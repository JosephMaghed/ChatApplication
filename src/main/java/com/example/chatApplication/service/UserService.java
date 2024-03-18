package com.example.chatApplication.service;

import com.example.chatApplication.Repo.UserRepo;
import com.example.chatApplication.exception.UserNotFoundException;
import com.example.chatApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Constructor with the necessary instances
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

public User addUser(User user){
    return userRepo.save(user);
}
    public void deleteUser(Long id){
    userRepo.deleteById(id);
}

List<User> findAllUsers(){
    return userRepo.findAll();
}
public User findUserById(Long id){
    return userRepo.findById(id).orElse(null);
}

//Search the user by user name
public Optional<List<User>> findUserByUserName(User UserName){
    if(UserName.getName()!=null){
    return userRepo.findUserByUserName(UserName.getName());
}else{
        return userRepo.findUserByUserName(UserName.getEmail());
    }
}

public User updateUser(Long id){

    User oldUser =userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not fond"));
    return userRepo.save(oldUser);
}
}
