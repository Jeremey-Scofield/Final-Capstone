package com.techelevator.model;

public class MtgCard {

    private String name;
    private String manaCost;
    private String type;
    private String text;
    private String power;
    private String toughness;
    private String setName;
    private String rarity;

    public MtgCard(String name, String manaCost, String type, String text,String power, String toughness, String setName, String rarity) {
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.text = text;
        this.power = power;
        this.toughness = toughness;
        this.setName = setName;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
