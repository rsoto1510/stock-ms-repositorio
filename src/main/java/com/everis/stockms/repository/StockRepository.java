package com.everis.stockms.repository;

import com.everis.stockms.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
   @Query("Select sum(quantity) from Stock where productid =?1")
    Integer totalStock(Integer productid);
}
