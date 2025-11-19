package com.hei.wallet.model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

  private String color;
  private List<String> cardHolder = new ArrayList<>();
  private double weight;
  private String brand;
  private double money;
  private boolean isLost;

  public Wallet() {
    this.cardHolder = new ArrayList<>();
    this.money = 0.0;
    this.isLost = false;
  }

  public Wallet(String color, double weight, String brand) {
    this.color = color;
    this.weight = weight;
    this.brand = brand;
    this.cardHolder = new ArrayList<>();
    this.money = 0.0;
    this.isLost = false;
  }

  public Wallet(String color, List<String> cardHolder, double weight, String brand, double money) {
    this.color = color;
    this.cardHolder = cardHolder != null ? new ArrayList<>(cardHolder) : new ArrayList<>();
    this.weight = weight;
    this.brand = brand;
    this.money = money;
    this.isLost = false;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public List<String> getCardHolder() {
    return new ArrayList<>(cardHolder);
  }

  public void setCardHolder(List<String> cardHolder) {
    this.cardHolder = cardHolder != null ? new ArrayList<>(cardHolder) : new ArrayList<>();
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  public boolean isLost() {
    return isLost;
  }

  public void setLost(boolean lost) {
    isLost = lost;
  }

  public void addMoney(double amount) {
    if (!isLost && amount > 0) {
      money += amount;
    } else {
      System.out.println("Amount must be positive");
    }
  }

  public double checkMoney() {
    return money;
  }

  public void addCard(String card) {
    if (!isLost) {
      if (!cardHolder.contains(card)) {
        cardHolder.add(card);
      } else {
        System.out.println("Card already exists.");
      }
    } else {
      System.out.println("Wallet is lost, cannot add card.");
    }
  }

  public boolean lost() {
    if (!isLost) {
      money = 0.0;
      cardHolder.clear();
      isLost = true;
    }
    return isLost;
  }
}
