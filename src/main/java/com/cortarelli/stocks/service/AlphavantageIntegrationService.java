package com.cortarelli.stocks.service;

import com.cortarelli.stocks.config.AlphavantageConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphavantageIntegrationService {

   private final AlphavantageConfig alphavantageConfig;

   public AlphavantageIntegrationService(AlphavantageConfig alphavantageConfig) {
      this.alphavantageConfig = alphavantageConfig;
   }

   private Gson gson = new GsonBuilder().serializeNulls().create();

   public JsonObject getOverview(String symbol, Boolean forceRefresh) {
      final StringBuilder uri = new StringBuilder(alphavantageConfig.getBaseUrl());
      uri.append("?function=OVERVIEW")
         .append("&symbol=").append(symbol)
         .append("&apikey=").append(alphavantageConfig.getApikey());

      RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(uri.toString(), String.class);

      return gson.fromJson(result, JsonObject.class);
   }

   public JsonObject getTimeSeriesDaily(String symbol, Boolean forceRefresh) {
      final StringBuilder uri = new StringBuilder(alphavantageConfig.getBaseUrl());
      uri.append("?function=TIME_SERIES_DAILY_ADJUSTED")
            .append("&symbol=").append(symbol)
            .append("&apikey=").append(alphavantageConfig.getApikey());

      RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(uri.toString(), String.class);

      return gson.fromJson(result, JsonObject.class);
   }

}
