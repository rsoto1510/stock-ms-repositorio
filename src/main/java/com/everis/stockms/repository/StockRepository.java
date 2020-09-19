package com.everis.stockms.repository;

import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.ResourceNotFoundException;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository <Stock,Integer>{

   // public Stock findCustomProductId (Integer id, Integer total);
}
