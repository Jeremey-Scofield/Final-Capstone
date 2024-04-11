package com.techelevator.dao;

import com.techelevator.model.Card;

public interface CardDao {
 Card getCard(int cardId);
 Card addCard(Card newCard);
 Card updateCard(Card updateCard);
 Card removeCard(int cardId);




}
