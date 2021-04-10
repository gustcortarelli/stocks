package com.cortarelli.stocks.entity;

import javax.persistence.*;

@Entity
public class User {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int id;
   @Column(unique=true, nullable = false)
   private String username;

   public User() {
      id = 0;
      username = "";
   }

   public User(int id, String username) {
      this.id = id;
      this.username = username;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }
}
