package com.techelevator.model;

public class Card {
    private int cardId;
    private String cardName;
    private String manaCost;
    private String cardColor;
    private String colorIdentity;
    private String cardType;
    private String  subType;
    private String rarity;
    private String set;
    private String setName;
    private String description;
    private String artist;

    public Card(int cardId, String cardName, String manaCost, String cardColor, String colorIdentity, String cardType, String subType, String rarity, String set, String setName, String description, String artist) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.manaCost = manaCost;
        this.cardColor = cardColor;
        this.colorIdentity = colorIdentity;
        this.cardType = cardType;
        this.subType = subType;
        this.rarity = rarity;
        this.set = set;
        this.setName = setName;
        this.description = description;
        this.artist = artist;
    }

    public Card() {

    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String  manaCost) {
        this.manaCost = manaCost;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(String colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
