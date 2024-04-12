package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.sql.ResultSet;

@Component
public class JdbcCollectionDao implements CollectionDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Card> getAllCards() {
        String sql = "SELECT * " +
                "FROM card " +
                "INNER JOIN collection_cards AS cc ON card.card_id = cc.card_id " +
                "WHERE cc.collection_id = 1;"; // Specify needed columns
        List<Card> cards = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Card card = new Card();
            card.setCardId(rs.getInt("card_id"));
            card.setCardName(rs.getString("card_name"));
            card.setManaCost(rs.getString("manacost"));
            card.setCardColor(rs.getString("colors"));
            card.setColorIdentity(rs.getString("coloridentity"));
            card.setCardType(rs.getString("type"));
            card.setSubType(rs.getString("subtype"));
            card.setRarity(rs.getString("rarity"));
            card.setSet(rs.getString("set"));
            card.setSetName(rs.getString("set_name"));
            card.setDescription(rs.getString("text"));
            card.setArtist((rs.getString("artist")));
            return card;
        });
        return cards;
    }

    public List<Collection> getAllCollections() {
        String sql = "SELECT * FROM collection";

        List<Collection> collections = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Collection collection = new Collection();
            collection.setCollectionId(rs.getInt("collection_id"));
            collection.setCollectionName(rs.getString("collection_name"));
            return collection;
        });
        return collections;
    }

    public List<Card> getAllCardsByCollection(int collectionId) {
        String sql = "SELECT c.* " +
                "FROM card AS c " +
                "INNER JOIN collection_cards AS cc ON c.card_id = cc.card_id " +
                "WHERE cc.collection_id = ?"; // Use prepared statement for parameter
        List<Card> cards = jdbcTemplate.query(sql, new Object[]{collectionId}, (rs, rowNum) -> {
            Card card = new Card();
            card.setCardId(rs.getInt("card_id"));
            card.setCardName(rs.getString("card_name"));
            card.setManaCost(rs.getString("manacost"));
            card.setCardColor(rs.getString("colors"));
            card.setColorIdentity(rs.getString("coloridentity"));
            card.setCardType(rs.getString("type"));
            card.setSubType(rs.getString("subtype"));
            card.setRarity(rs.getString("rarity"));
            card.setSet(rs.getString("set"));
            card.setSetName(rs.getString("set_name"));
            card.setDescription(rs.getString("text"));
            card.setArtist((rs.getString("artist")));
            return card;
        });
        return cards;
    }


    public List<Card> getAllCollectionsByUserId() {
        return null;
    }

    public Card getCardByCardId(int cardId) {
        String sql = "SELECT * FROM card WHERE card_id = ?";
        Card retrievedCard = jdbcTemplate.queryForObject(sql, new Object[]{cardId}, (rs, rowNum) -> {
            Card card = new Card();
            card.setCardId(rs.getInt("card_id"));
            card.setCardName(rs.getString("card_name"));
            card.setManaCost(rs.getString("manacost"));
            card.setCardColor(rs.getString("colors"));
            card.setColorIdentity(rs.getString("coloridentity"));
            card.setCardType(rs.getString("type"));
            card.setSubType(rs.getString("subtype"));
            card.setRarity(rs.getString("rarity"));
            card.setSet(rs.getString("set"));
            card.setSetName(rs.getString("set_name")); 
            card.setDescription(rs.getString("text"));
            card.setArtist((rs.getString("artist")));
            return card;
        });
        return retrievedCard;
    }
}
