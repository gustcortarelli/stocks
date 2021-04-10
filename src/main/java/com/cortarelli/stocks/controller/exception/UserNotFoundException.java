package com.cortarelli.stocks.controller.exception;

public class UserNotFoundException extends Exception {
   public UserNotFoundException(String username){
      super(String.format("User \"%s\" not found", username));
   }
   public UserNotFoundException(Integer id){
      super(String.format("User id \"%s\" not found", id));
   }
}
