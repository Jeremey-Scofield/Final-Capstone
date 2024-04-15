package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private CollectionDao collectionDao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Collection> getAllCollections() {
        return collectionDao.getAllCollections();
    }

    @RequestMapping(path = "/{collectionId}", method = RequestMethod.GET)
    public Collection getCollectionId(@PathVariable int collectionId) {
        return collectionDao.getCollectionById(collectionId);
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public List<Collection> getCollectionsByUserId(@PathVariable int userId) {
        return collectionDao.getCollectionsByUserId(userId);
    }

    @RequestMapping(path = "/{collectionId}/cards", method = RequestMethod.GET)
    public List<String> getCardsByCollectionsId(@PathVariable int collectionId) {
        return collectionDao.getCardsByCollectionId(collectionId);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public Collection createCollection(@RequestBody Collection collection) {
        return collectionDao.createCollection(collection);
    }

    @RequestMapping(path = "/cards/new", method = RequestMethod.POST)
    public void addCardToCollection(@RequestBody CollectionCard card) {
        collectionDao.addCardToCollection(card.getCollectionId(), card.getCardId());
    }

    @RequestMapping(path = "/cards/delete", method = RequestMethod.DELETE)
    public void deleteCard(@RequestBody CollectionCard card) {
        collectionDao.deleteCardFromCollection(card.getCollectionId(), card.getCardId());
    }

    @RequestMapping(path = "/delete/{collectionId}", method = RequestMethod.DELETE)
    public void deleteCollection(@PathVariable int collectionId) {
        collectionDao.deleteCollection(collectionId);
    }
}
