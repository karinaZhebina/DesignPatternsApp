package com.epam.rd.autocode.startegy.cards;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClassicPokerCardDealingStrategy implements CardDealingStrategy {

  @Override
  public Map<String, List<Card>> dealStacks(Deck deck, int players) {
    Map<String, List<Card>> dealMap = new HashMap<>();
    cardsForPlayers(players, deck, dealMap);
    dealMap.put("Remaining", deck.restCards());
    return dealMap;
  }

  private void cardsForPlayers(int players, Deck deck, Map<String, List<Card>> dealMap) {
    int cardsPerPlayer = 5;
    for (int i = 1; i <= players; i++) {
      String player = "Player " + i;
      dealMap.put(player, new LinkedList<>());
    }
    for (int i = 0; i < cardsPerPlayer; i++) {
      for (int n = 1; n <= players; n++) {
        dealMap.get("Player " + n).add(deck.dealCard());
      }
    }
  }

}
