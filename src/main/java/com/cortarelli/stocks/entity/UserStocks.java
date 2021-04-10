package com.cortarelli.stocks.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class UserStocks {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private int id;
   @Column(nullable = false)
   private int userId;
   @Column(nullable = false)
   private String symbol;
   @Column(nullable = false)
   private BigDecimal quantity;
   @Column(nullable = false)
   private Date date;
   @Column(nullable = false)
   private BigDecimal value;

   public UserStocks() {
      this.id = 0;
      this.userId = 0;
      this.symbol = "";
      this.quantity = BigDecimal.valueOf(0.0);
      this.date = null;
      this.value = BigDecimal.valueOf(0.0);
   }

   public UserStocks(int id, int userId, String symbol, BigDecimal quantity, Date date, BigDecimal value) {
      this.id = id;
      this.userId = userId;
      this.symbol = symbol;
      this.quantity = quantity;
      this.date = date;
      this.value = value;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   public BigDecimal getQuantity() {
      return quantity;
   }

   public void setQuantity(BigDecimal quantity) {
      this.quantity = quantity;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public BigDecimal getValue() {
      return value;
   }

   public void setValue(BigDecimal value) {
      this.value = value;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserStocks that = (UserStocks) o;
      return id == that.id &&
            quantity == that.quantity &&
            Objects.equals(symbol, that.symbol) &&
            Objects.equals(date, that.date) &&
            Objects.equals(value, that.value);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, symbol, quantity, date, value);
   }

   @Override
   public String toString() {
      return "UserStocks{" +
            "id=" + id +
            ", symbol='" + symbol + '\'' +
            ", quantity=" + quantity +
            ", date=" + date +
            ", value=" + value +
            '}';
   }
}
