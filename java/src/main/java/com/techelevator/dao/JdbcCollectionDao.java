package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Collection> getAllCollections() {
        List<Collection> collections = new ArrayList<>();

        String sql = "SELECT collection_id, collection_name, users.user_id, username " +
                "FROM collections " +
                "JOIN users ON collections.user_id = users.user_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Collection collectionResult = mapRowtoCollection(results);
                collections.add(collectionResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int collectionId) {
        Collection collection = null;
        String sql = "SELECT collection_id, collection_name, user_id " +
                "FROM collections " +
                "WHERE collection_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            if (results.next()) {
                collection = mapRowtoCollectionnoUsername(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return collection;
    }

    @Override
    public List<Collection> getCollectionsByUserId(int userId) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id " +
                "FROM collections " +
                "WHERE user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Collection collectionResult = mapRowtoCollectionnoUsername(results);
                collections.add(collectionResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return collections;
    }

    @Override
    public List<String> getCardsByCollectionId(int collectionId) {
        List<String> cardIds = new ArrayList<>();
        String sql = "SELECT card_id " +
                "FROM collection_cards " +
                "WHERE collection_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
            while (results.next()) {

                cardIds.add(results.getString("card_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return cardIds;
    }

    @Override
    public Collection createCollection(Collection collection) {
        Collection newCollection = null;
        String sql = "INSERT INTO public.collections(collection_name, user_id) " +
                "VALUES (?, ?) RETURNING collection_id;";
        try {
            int newCollectionId = jdbcTemplate.queryForObject(sql, int.class,
                    collection.getCollectionName(), collection.getUserId());
            newCollection = getCollectionById(newCollectionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar: " + sql, e);
        }
        return newCollection;
    }

    @Override
    public void addCardToCollection(int collectionId, String cardId) {
        String sql = "INSERT INTO public.collection_cards(collection_id, card_id) " +
                "VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, collectionId, cardId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar: " + sql, e);
        }
    }

    @Override
    public int deleteCardFromCollection(int collectionId, String cardId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM public.collection_cards " +
                "WHERE collection_id = ? AND card_id = ?;";
        try {
            numberOfRows = jdbcTemplate.update(sql, collectionId, cardId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar: " + sql, e);
        }
        return numberOfRows;
    }

    @Override
    public int deleteCollection(int collectionId) {
        int numberOfRows = 0;
        String sqlDeleteCards = "DELETE FROM collection_cards WHERE collection_id = ?;";
        String sqlDelectCollection = "DELETE FROM collections WHERE collection_id = ?;";

        try {
            jdbcTemplate.update(sqlDeleteCards, collectionId);
            numberOfRows = jdbcTemplate.update(sqlDelectCollection, collectionId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar.", e);
        }
        return numberOfRows;
    }

    private Collection mapRowtoCollection(SqlRowSet row) {
        Collection collection = new Collection();
        collection.setCollectionId(row.getInt("collection_id"));
        collection.setCollectionName(row.getString("collection_name"));
        collection.setUserId(row.getInt("user_id"));
        collection.setUsername(row.getString("username"));


        return collection;
    }

    private Collection mapRowtoCollectionnoUsername(SqlRowSet row) {
        Collection collection = new Collection();
        collection.setCollectionId(row.getInt("collection_id"));
        collection.setCollectionName(row.getString("collection_name"));
        collection.setUserId(row.getInt("user_id"));


        return collection;
    }
}
