package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Card;
import com.techelevator.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CollectionDao collectionDao;

    @GetMapping("/{id}")
    public ResponseEntity<Card> getAllCardsByCollectionId(@PathVariable("id") int cardId) {
        Card card = collectionDao.getCardByCardId(cardId);

        if(card == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(card);
        }
    }



}
