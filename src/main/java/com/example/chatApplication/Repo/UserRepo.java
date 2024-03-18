package com.example.chatApplication.Repo;

import com.example.chatApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.name = :userName OR u.email = :userName")
    Optional<List<User>> findUserByUserName(String userName);

    }
