package com.cortarelli.stocks.controller;


import com.cortarelli.stocks.controller.exception.UserNotFoundException;
import com.cortarelli.stocks.controller.exception.UserStocksNotFoundException;
import com.cortarelli.stocks.entity.User;
import com.cortarelli.stocks.entity.UserStocks;
import com.cortarelli.stocks.service.UserService;
import com.cortarelli.stocks.service.UserStocksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/user/{user-id}/stocks")
public class UserStocksController {

   private Logger logger = LoggerFactory.getLogger(getClass());

   @Autowired
   private UserStocksService userStocksService;
   @Autowired
   private UserService userService;

   @GetMapping
   List<UserStocks> getUserStocks(@PathVariable("user-id") int userId) {
      return userStocksService.findByUserId(userId);
   }

   @GetMapping("/symbol/{symbol}")
   List<UserStocks> getUserStocksBySymbol(@PathVariable("user-id") int userId, @PathVariable("symbol") String symbol) {
      return userStocksService.findByUserIdAndSymbol(userId, symbol);
   }

   @GetMapping("/{id}")
   UserStocks getUserStocksById(@PathVariable("user-id") int userId, @PathVariable("id") int id) throws UserStocksNotFoundException {
      return userStocksService.findByIdAndUserId(id, userId).orElseThrow(() -> new UserStocksNotFoundException(userId, id));
   }

   @PostMapping
   UserStocks save(@PathVariable("user-id") int userId, @RequestBody UserStocks userStocks) throws UserNotFoundException {
      User user = userService.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
      userStocks.setUserId(user.getId());
      return userStocksService.save(userStocks);
   }

   @PutMapping("/{id}")
   UserStocks update(@PathVariable("user-id") int userId, @PathVariable("id") int id, @RequestBody UserStocks userStocks)
         throws UserNotFoundException, UserStocksNotFoundException {

      userService.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
      userStocks.setUserId(userId);

      userStocksService.findByIdAndUserId(id, userId).orElseThrow(() -> new UserStocksNotFoundException(userId, id));
      userStocks.setId(id);

      return userStocksService.save(userStocks);
   }

   @ExceptionHandler(UserStocksNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public void handlerNotFoundException(UserStocksNotFoundException e) {
      logger.info(e.getMessage(), e);
   }

   @ExceptionHandler(UserNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public void handlerNotFoundException(UserNotFoundException e) {
      logger.info(e.getMessage(), e);
   }

}
