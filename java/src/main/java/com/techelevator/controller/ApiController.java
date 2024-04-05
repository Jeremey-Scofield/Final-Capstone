package com.techelevator.controller;

import com.techelevator.model.ApiModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/jokes")
public class JokeController {
    private APIService cardService;

    public ApiController(){
        this.cardService = new APIService();
    }
    @RequestMapping(path="", method = RequestMethod.GET)
    public String getJoke() {
        ApiModel cardSet = new ApiModel();
        joke = jokeService.getJokeFromApi();

        return joke.value;
    }
}


