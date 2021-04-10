package com.cortarelli.stocks.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"symbol","function","driver"})})
public class StocksData {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private int id;
   @Column(nullable = false)
   private String symbol;
   @Column(nullable = false)
   private String function;
   @Column(nullable = false)
   private String driver;
   @Column(nullable = false)
   private Date requestDate;
   @Column(nullable = false)
   private String requestParameters;
   @Lob
   @Column(nullable = false)
   private String data;

   public StocksData() {
      this.id = 0;
      this.symbol = "";
      this.function = "";
      this.requestDate = null;
      this.requestParameters = "";
   }

   public StocksData(int id, String symbol, String function, Date requestDate, String requestParameters) {
      this.id = id;
      this.symbol = symbol;
      this.function = function;
      this.requestDate = requestDate;
      this.requestParameters = requestParameters;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   public String getFunction() {
      return function;
   }

   public void setFunction(String function) {
      this.function = function;
   }

   public Date getRequestDate() {
      return requestDate;
   }

   public void setRequestDate(Date requestDate) {
      this.requestDate = requestDate;
   }

   public String getRequestParameters() {
      return requestParameters;
   }

   public void setRequestParameters(String requestParameters) {
      this.requestParameters = requestParameters;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      StocksData that = (StocksData) o;
      return id == that.id &&
            Objects.equals(symbol, that.symbol) &&
            Objects.equals(function, that.function) &&
            Objects.equals(requestDate, that.requestDate) &&
            Objects.equals(requestParameters, that.requestParameters);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, symbol, function, requestDate, requestParameters);
   }

   @Override
   public String toString() {
      return "StocksData{" +
            "id=" + id +
            ", symbol='" + symbol + '\'' +
            ", function='" + function + '\'' +
            ", requestDate=" + requestDate +
            ", requestParameters='" + requestParameters + '\'' +
            '}';
   }
}
