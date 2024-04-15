package com.techelevator.model;

public class CollectionCard {
    private int collectionId;
    private String cardId;

    public CollectionCard(int collectionId, String cardId) {
        this.collectionId = collectionId;
        this.cardId = cardId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
