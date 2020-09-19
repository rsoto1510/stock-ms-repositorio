package com.everis.stockms.service;

import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;

import java.util.List;

public interface StockService {

    public Stock customStockId (Integer id) throws ResourceNotFoundException;
    public Stock totalStock( Integer total);


    public List<Stock> listAll();
    public Stock save(Stock stock) throws BusinessException;




}
