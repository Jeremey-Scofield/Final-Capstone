package com.techelevator.controller;

import com.techelevator.model.MtgCard;
import com.techelevator.services.MtgCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1") // Versioning your API endpoints (optional)
public class MtgCardController {

    @Autowired
    private MtgCardService mtgCardService;

    @GetMapping("/cards")
    public List<MtgCard> getCardsByName(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return mtgCardService.getCardsByName(name);
        } else {
            return new ArrayList<>();
            //Could add a default case for no cards returning
        }
    }
}