package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {

    public List<Collection> getAllCollections();

    public Collection getCollectionById(int collectionId);

    public List<Collection> getCollectionsByUserId(int userId);

    public List<String> getCardsByCollectionId(int collectionId);

    public Collection createCollection(Collection collection);

    public void addCardToCollection(int collectionId, String cardId);

    public int deleteCardFromCollection(int collectionId, String cardId);

    public int deleteCollection(int collectionId);

}
