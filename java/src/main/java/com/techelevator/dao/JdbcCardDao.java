package com.techelevator.dao;

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
    public Card getCardId(int cardId) {
        return null;
    }

    @Override
    public Card addCard(Card newCard) {
        Card addedCard = null;
        String sql = "Insert INTO collection (card) VALUES (?) RETURNING card_id";
        try {
            int newCardId = jdbcTemplate.queryForObject(sql, int.class, cardId);
            log.debug("created new Transfer with ID: " + newCardId);
            addedCard = getCardId(newCardId);
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
