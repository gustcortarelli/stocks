package com.cortarelli.stocks.controller.exception;

public class UserStocksNotFoundException extends Exception {
   public UserStocksNotFoundException(Integer userId, Integer id){
      super(String.format("User id \"%s\" - stock id %s is not found", userId, id));
   }
}
