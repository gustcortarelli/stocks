package com.cortarelli.stocks.repository;

import com.cortarelli.stocks.entity.StocksData;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StocksDataRepository extends Repository<StocksData, Integer> {

   List<StocksData> findBySymbolAndFunction(String symbol, String operation);

   StocksData save(StocksData stocksData);

   void deleteById(int id);

}
