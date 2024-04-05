package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

public class APIService {

    private static final String API_BASE_URL = "https://api.scryfall.com/sets";
    private final RestTemplate restTemplate = new RestTemplate();

    public CardSet getSetsFromApi(){
        CardSet cardset = new CardSet();
        cardset = restTemplate.getForObject(API_BASE_URL, CardSet.class);
        return cardset;
    }


}
