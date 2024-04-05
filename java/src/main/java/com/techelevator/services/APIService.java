package com.techelevator.services;

import com.techelevator.model.ApiModel;
import org.springframework.web.client.RestTemplate;

public class APIService {

    private static final String API_BASE_URL = "https://api.scryfall.com/sets";
    private final RestTemplate restTemplate = new RestTemplate();

    public ApiModel getSetsFromApi(){
        ApiModel cardset = new ApiModel();
        cardset = restTemplate.getForObject(API_BASE_URL, ApiModel.class);
        return cardset;
    }


}
