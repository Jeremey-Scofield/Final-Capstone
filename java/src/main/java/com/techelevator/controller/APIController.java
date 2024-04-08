package com.techelevator.controller;

import com.techelevator.model.ApiModel;
import com.techelevator.services.APIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sets")
public class APIController {
    private APIService cardService;

    public APIController() {
        this.cardService = new APIService();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ApiModel getSet() {
        ApiModel cardSet = new ApiModel();
        cardSet = cardService.getSetsFromApi();

        return cardSet;
    }

}
