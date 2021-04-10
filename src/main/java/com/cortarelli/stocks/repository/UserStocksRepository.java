package com.cortarelli.stocks.repository;

import com.cortarelli.stocks.entity.UserStocks;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserStocksRepository extends Repository<UserStocks, Integer> {

   List<UserStocks> findByUserId(int userId);

   List<UserStocks> findByUserIdAndSymbol(int userId, String symbol);

   Optional<UserStocks> findByIdAndUserId(int id, int userId);

   UserStocks save(UserStocks stocksData);

   void deleteById(int id);

}
