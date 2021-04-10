package com.cortarelli.stocks.service;

import com.cortarelli.stocks.entity.UserStocks;
import com.cortarelli.stocks.repository.UserStocksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStocksService {

   private final UserStocksRepository userStocksRepository;

   public UserStocksService(UserStocksRepository userStocksRepository) {
      this.userStocksRepository = userStocksRepository;
   }

   public List<UserStocks> findByUserId(int userId) {
      return userStocksRepository.findByUserId(userId);
   }

   public List<UserStocks> findByUserIdAndSymbol(int userId, String symbol) {
      return userStocksRepository.findByUserIdAndSymbol(userId, symbol);
   }

   public Optional<UserStocks> findByIdAndUserId(int id, int userId) {
      return userStocksRepository.findByIdAndUserId(id, userId);
   }

   public UserStocks save(UserStocks userStocks) {
      return userStocksRepository.save(userStocks);
   }

   public void delete(int id) {
      userStocksRepository.deleteById(id);
   }

}
