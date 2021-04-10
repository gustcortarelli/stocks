package com.cortarelli.stocks.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "alphavantage")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class AlphavantageConfig {

   private String baseUrl;
   private String apikey;

   public String getBaseUrl() {
      return baseUrl;
   }

   public String getApikey() {
      return apikey;
   }

   public void setBaseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
   }

   public void setApikey(String apikey) {
      this.apikey = apikey;
   }
}
