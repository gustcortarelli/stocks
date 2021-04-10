package com.cortarelli.stocks.repository;

import com.cortarelli.stocks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

   Optional<User> findByUsername(String username);

   void deleteById(int id);

}
