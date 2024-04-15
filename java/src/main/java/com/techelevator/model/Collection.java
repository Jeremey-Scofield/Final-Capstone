package com.techelevator.model;

public class Collection {

    private int collectionId;
    private String collectionName;
    private int userId;

    public Collection(String collectionName, int userId) {
        this.collectionName = collectionName;
        this.userId = userId;
    }

    public Collection() {}

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
}
