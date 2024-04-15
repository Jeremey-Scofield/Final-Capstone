package com.techelevator.model;

public class Collection {

    private int collectionId;
    private String collectionName;
    private int userId;
    private String userName;

<<<<<<< HEAD
    public Collection(String collectionName, int userId, String userName) {
        this.collectionName = collectionName;
        this.userId = userId;
        this.userName= userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
=======
    private String username;

    public Collection(String collectionName, int userId, String username) {
        this.collectionName = collectionName;
        this.userId = userId;
        this.username = username;
>>>>>>> 3e1801bdd86c3a9e6794932f0290e068da56aef7
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
}
