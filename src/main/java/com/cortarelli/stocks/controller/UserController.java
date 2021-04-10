package com.cortarelli.stocks.controller;

import com.cortarelli.stocks.controller.exception.UserNotFoundException;
import com.cortarelli.stocks.entity.User;
import com.cortarelli.stocks.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/user")
public class UserController {

   private Logger logger = LoggerFactory.getLogger(getClass());

   @Autowired
   private UserService userService;

   @GetMapping
   public List<User> findAll() {
      return userService.findAll();
   }

   @GetMapping("/name/{username}")
   public User findByUsername(@PathVariable("username") String username) throws UserNotFoundException {
      return userService.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
   }

   @GetMapping("/{id}")
   public User findById(@PathVariable("id") int id) throws UserNotFoundException {
      return userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
   }

   @PostMapping
   public User save(@RequestBody User user) {
      return userService.save(user);
   }

   @PutMapping("/{id}")
   public User update(@PathVariable("id") int id, @RequestBody User user) throws UserNotFoundException {
      userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
      user.setId(id);
      return userService.save(user);
   }

   @ExceptionHandler(UserNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public void handlerNotFoundException(UserNotFoundException e) {
      logger.info(e.getMessage(), e);
   }

}
