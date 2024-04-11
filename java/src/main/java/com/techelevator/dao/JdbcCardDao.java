package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Card;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCardDao implements CardDao{
    private JdbcTemplate jdbcTemplate;
    @Override
    public Card getCard(int cardId) {
        return null;
    }

    @Override
    public Card addCard(Card newCard) {
        Card addedCard = null;
        String sql = "INSERT INTO public.card( " +
                "card_name, manacost, colors, coloridentity, type, subtype, rarity, set, set_name, artist) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        //todo add image and text
        try {
            int newCardId = jdbcTemplate.queryForObject(sql, int.class, addedCard.getCardName(), addedCard.getManaCost(), addedCard.getCardColor(), addedCard.getColorIdentity(),
                    addedCard.getSubType(), addedCard.getSubType(), addedCard.getRarity(), addedCard.getSet(), addedCard.getSetName(), addedCard.getArtist());

            addedCard = getCard(newCardId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return addedCard;
    }

    @Override
    public Card updateCard(Card updateCard) {
        return null;
    }

    @Override
    public Card removeCard(int cardId) {
        return null;
    }
}
