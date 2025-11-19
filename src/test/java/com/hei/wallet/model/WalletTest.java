package com.hei.wallet.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WalletTest {

  private Wallet wallet;

  @BeforeEach
  void setup() {
    wallet = new Wallet("Black", 0.5, "Gucci");
  }

  @Test
  void testInitialValues() {
    assertEquals("Black", wallet.getColor());
    assertEquals(0.5, wallet.getWeight());
    assertEquals("Gucci", wallet.getBrand());
    assertEquals(0.0, wallet.getMoney());
    assertFalse(wallet.isLost());
    assertTrue(wallet.getCardHolder().isEmpty());
  }

  @Test
  void testAddMoney() {
    wallet.addMoney(100.0);
    assertEquals(100.0, wallet.checkMoney());

    wallet.addMoney(-50.0);
    assertEquals(100.0, wallet.checkMoney());
  }

  @Test
  void testAddCard() {
    wallet.addCard("Visa");
    wallet.addCard("MasterCard");

    List<String> cards = wallet.getCardHolder();
    assertEquals(2, cards.size());
    assertTrue(cards.containsAll(Arrays.asList("Visa", "MasterCard")));

    wallet.addCard("Visa");
    assertEquals(2, wallet.getCardHolder().size());
  }

  @Test
  void testLost() {
    wallet.addMoney(50.0);
    wallet.addCard("Visa");

    assertFalse(wallet.isLost());
    wallet.lost();

    assertTrue(wallet.isLost());
    assertEquals(0.0, wallet.checkMoney());
    assertTrue(wallet.getCardHolder().isEmpty());

    wallet.addMoney(100.0);
    wallet.addCard("MasterCard");
    assertEquals(0.0, wallet.checkMoney());
    assertTrue(wallet.getCardHolder().isEmpty());
  }

  @Test
  void testConstructorWithCardList() {
    List<String> initialCards = Arrays.asList("Visa", "Amex");
    Wallet w = new Wallet("Red", initialCards, 0.3, "Prada", 200.0);

    assertEquals("Red", w.getColor());
    assertEquals(0.3, w.getWeight());
    assertEquals("Prada", w.getBrand());
    assertEquals(200.0, w.getMoney());
    assertEquals(2, w.getCardHolder().size());
    assertFalse(w.isLost());
  }
}
