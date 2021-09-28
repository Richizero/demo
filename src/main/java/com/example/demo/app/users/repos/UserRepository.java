package com.example.demo.app.users.repos;


import com.example.demo.app.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
