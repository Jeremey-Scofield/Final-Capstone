package com.techelevator.services;

import com.techelevator.dao.MtgCardRepository;
import com.techelevator.model.MtgCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MtgCardService {

    private RestTemplate restTemplate;


    public List<MtgCard> getCardsByName(String name) {
        String url = "https://api.scryfall.com/cards/search?q={name}";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, name);

        if (response.getStatusCode() == HttpStatus.OK) {
            String jsonString = response.getBody();
            List<MtgCard> cards = new ArrayList<>();

            // Assuming the response has a key "data" containing the card array
            int startIndex = jsonString.indexOf("\"data\": [");
            if (startIndex != -1) {
                int endIndex = jsonString.indexOf("]", startIndex);
                String cardArrayString = jsonString.substring(startIndex + 9, endIndex); // Extract the card array string

                // Iterate through each card object (assuming a simple JSON structure)
                for (String cardString : cardArrayString.split("\\},")) {
                    String nameValue = getValueFromJson(cardString, "\"name\":");
                    String manaCostValue = getValueFromJson(cardString, "\"mana_cost\":");
                    String typeValue = getValueFromJson(cardString, "\"type_line\":");
                    String textValue = getValueFromJson(cardString, "\"oracle_text\":");
                    String powerValue = getValueFromJson(cardString, "\"power\":");
                    String toughnessValue = getValueFromJson(cardString, "\"toughness\":");
                    String setNameValue = getValueFromJson(cardString, "\"set_name\":");
                    String rarityValue = getValueFromJson(cardString, "\"rarity\":");

                    MtgCard card = new MtgCard(nameValue, manaCostValue, typeValue, textValue, powerValue, toughnessValue, setNameValue, rarityValue);
                    cards.add(card);
                }
            }
            return cards;
        } else {
            // Handle unsuccessful response (e.g., log error, return empty list)
            System.out.println("API call unsuccessful. Status code: " + response.getStatusCode());
            return new ArrayList<>();
        }
    }

        /*
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.text = text;
        this.toughness = toughness;
        this.setName = setName;
        this.rarity = rarity;
         */

        /*
        {
    "object": "list",
    "total_cards": 9,
    "has_more": false,
    "data": [
        {
            "object": "card",
            "id": "8b71345a-c3e8-4b35-beb7-6347e41d7626",
            "oracle_id": "0b9be4fa-5238-4afd-a9f6-f9022e67e5ab",
            "multiverse_ids": [
                589594
            ],
            "tcgplayer_id": 454812,
            "cardmarket_id": 686320,
            "name": "Kibo, Uktabi Prince",
            "lang": "en",
            "released_at": "2022-12-02",
            "uri": "https://api.scryfall.com/cards/8b71345a-c3e8-4b35-beb7-6347e41d7626",
            "scryfall_uri": "https://scryfall.com/card/j22/40/kibo-uktabi-prince?utm_source=api",
            "layout": "normal",
            "highres_image": true,
            "image_status": "highres_scan",
            "image_uris": {
                "small": "https://cards.scryfall.io/small/front/8/b/8b71345a-c3e8-4b35-beb7-6347e41d7626.jpg?1675644790",
                "normal": "https://cards.scryfall.io/normal/front/8/b/8b71345a-c3e8-4b35-beb7-6347e41d7626.jpg?1675644790",
                "large": "https://cards.scryfall.io/large/front/8/b/8b71345a-c3e8-4b35-beb7-6347e41d7626.jpg?1675644790",
                "png": "https://cards.scryfall.io/png/front/8/b/8b71345a-c3e8-4b35-beb7-6347e41d7626.png?1675644790",
                "art_crop": "https://cards.scryfall.io/art_crop/front/8/b/8b71345a-c3e8-4b35-beb7-6347e41d7626.jpg?1675644790",
                "border_crop": "https://cards.scryfall.io/border_crop/front/8/b/8b71345a-c3e8-4b35-beb7-6347e41d7626.jpg?1675644790"
            },
            "mana_cost": "{2}{G}",
            "cmc": 3.0,
            "type_line": "Legendary Creature — Monkey Noble",
            "oracle_text": "{T}: Each player creates a colorless artifact token named Banana with \"{T}, Sacrifice this artifact: Add {R} or {G}. You gain 2 life.\"\nWhenever an artifact an opponent controls is put into a graveyard from the battlefield, put a +1/+1 counter on each creature you control that's an Ape or a Monkey.\nWhenever Kibo attacks, defending player sacrifices an artifact.",
            "power": "2",
            "toughness": "2",
            "colors": [
                "G"
            ],
            "color_identity": [
                "G",
                "R"
            ],
            "keywords": [],
            "produced_mana": [
                "G",
                "R"
            ],
            "legalities": {
                "standard": "not_legal",
                "future": "not_legal",
                "historic": "not_legal",
                "timeless": "not_legal",
                "gladiator": "not_legal",
                "pioneer": "not_legal",
                "explorer": "not_legal",
                "modern": "not_legal",
                "legacy": "legal",
                "pauper": "not_legal",
                "vintage": "legal",
                "penny": "not_legal",
                "commander": "legal",
                "oathbreaker": "legal",
                "standardbrawl": "not_legal",
                "brawl": "not_legal",
                "alchemy": "not_legal",
                "paupercommander": "not_legal",
                "duel": "legal",
                "oldschool": "not_legal",
                "premodern": "not_legal",
                "predh": "not_legal"
            },
            "games": [
                "paper"
            ],
            "reserved": false,
            "foil": false,
            "nonfoil": true,
            "finishes": [
                "nonfoil"
            ],
            "oversized": false,
            "promo": false,
            "reprint": false,
            "variation": false,
            "set_id": "247df475-e4ce-4e5e-9317-11892d2211e0",
            "set": "j22",
            "set_name": "Jumpstart 2022",
            "set_type": "draft_innovation",
            "set_uri": "https://api.scryfall.com/sets/247df475-e4ce-4e5e-9317-11892d2211e0",
            "set_search_uri": "https://api.scryfall.com/cards/search?order=set&q=e%3Aj22&unique=prints",
            "scryfall_set_uri": "https://scryfall.com/sets/j22?utm_source=api",
            "rulings_uri": "https://api.scryfall.com/cards/8b71345a-c3e8-4b35-beb7-6347e41d7626/rulings",
            "prints_search_uri": "https://api.scryfall.com/cards/search?order=released&q=oracleid%3A0b9be4fa-5238-4afd-a9f6-f9022e67e5ab&unique=prints",
            "collector_number": "40",
            "digital": false,
            "rarity": "mythic",
            "card_back_id": "0aeebaf5-8c7d-4636-9e82-8c27447861f7",
            "artist": "Zoltan Boros",
            "artist_ids": [
                "1885e6cb-c827-4896-994e-3d0a027d602f"
            ],
            "illustration_id": "f99b5fc5-40be-441d-b4a9-eaa9fecf356b",
            "border_color": "black",
            "frame": "2015",
            "frame_effects": [
                "legendary"
            ],
            "security_stamp": "oval",
            "full_art": false,
            "textless": false,
            "booster": true,
            "story_spotlight": false,
            "edhrec_rank": 5133,
            "preview": {
                "source": "Wizards of the Coast",
                "source_uri": "https://www.twitch.tv/videos/1649098495",
                "previewed_at": "2022-11-12"
            },
            "prices": {
                "usd": "4.99",
                "usd_foil": null,
                "usd_etched": null,
                "eur": "2.63",
                "eur_foil": null,
                "tix": null
            },
            "related_uris": {
                "gatherer": "https://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=589594&printed=false",
                "tcgplayer_infinite_articles": "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&trafcat=infinite&u=https%3A%2F%2Finfinite.tcgplayer.com%2Fsearch%3FcontentMode%3Darticle%26game%3Dmagic%26partner%3Dscryfall%26q%3DKibo%252C%2BUktabi%2BPrince",
                "tcgplayer_infinite_decks": "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&trafcat=infinite&u=https%3A%2F%2Finfinite.tcgplayer.com%2Fsearch%3FcontentMode%3Ddeck%26game%3Dmagic%26partner%3Dscryfall%26q%3DKibo%252C%2BUktabi%2BPrince",
                "edhrec": "https://edhrec.com/route/?cc=Kibo%2C+Uktabi+Prince"
            },
            "purchase_uris": {
                "tcgplayer": "https://tcgplayer.pxf.io/c/4931599/1830156/21018?subId1=api&u=https%3A%2F%2Fwww.tcgplayer.com%2Fproduct%2F454812%3Fpage%3D1",
                "cardmarket": "https://www.cardmarket.com/en/Magic/Products/Singles/Jumpstart-2022/Kibo-Uktabi-Prince?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "cardhoarder": "https://www.cardhoarder.com/cards?affiliate_id=scryfall&data%5Bsearch%5D=Kibo%2C+Uktabi+Prince&ref=card-profile&utm_campaign=affiliate&utm_medium=card&utm_source=scryfall"
            }
        },
         */

    private String getValueFromJson(String jsonString, String key) {
        int keyIndex = jsonString.indexOf(key);
        if (keyIndex != -1) {
            int valueStartIndex = jsonString.indexOf(':', keyIndex) + 1;
            int valueEndIndex = jsonString.indexOf(',', valueStartIndex);
            if (valueEndIndex == -1) {
                valueEndIndex = jsonString.length();
            }
            return jsonString.substring(valueStartIndex, valueEndIndex).trim();
        }
        return null;
    }


}
