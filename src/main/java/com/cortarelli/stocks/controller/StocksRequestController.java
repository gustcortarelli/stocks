package com.cortarelli.stocks.controller;

import com.cortarelli.stocks.service.AlphavantageIntegrationService;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/API/stocks")
public class StocksRequestController {

   private Logger logger = LoggerFactory.getLogger(getClass());

   @Autowired
   private AlphavantageIntegrationService alphavantageIntegrationService;

   @GetMapping("/overview/{symbol}/{force-refresh}")
   public JsonObject getCompanyOverview(@PathVariable("symbol") String symbol, @PathVariable("force-refresh") Optional<Boolean> forceRefresh) {
      return alphavantageIntegrationService.getOverview(symbol, forceRefresh.orElse(false));
   }

   @GetMapping("/timeseries/daily/{symbol}/{force-refresh}")
   public JsonObject get(@PathVariable("symbol") String symbol, @PathVariable("force-refresh") Optional<Boolean> forceRefresh) {
      return alphavantageIntegrationService.getTimeSeriesDaily(symbol, forceRefresh.orElse(false));
   }

}
