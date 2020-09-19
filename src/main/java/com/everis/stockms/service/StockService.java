package com.everis.stockms.service;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;

import java.util.List;

public interface StockService {

    public List<Stock> save(List<Stock> stockList) throws BusinessException;

    public FindByProductIdDto totalStock(Integer productid) throws ResourceNotFoundException;



}
