package com.techelevator.dao;

import com.techelevator.model.MtgCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MtgCardRepository extends CrudRepository<MtgCard, Long> {
    List<MtgCard> findByNameContaining(String name);
}
