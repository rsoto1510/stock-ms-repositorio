package com.everis.stockms.service;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;
import com.everis.stockms.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements  StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public FindByProductIdDto totalStock(Integer productid) throws ResourceNotFoundException {
        Integer suma = stockRepository.totalStock(productid);
        if (suma == null){
            throw new ResourceNotFoundException();
        }
        FindByProductIdDto result = new FindByProductIdDto();
        result.setProductid(productid);
        result.setTotal(suma);
        return result;

    }

    @Override
    public List<Stock> save(List<Stock> stockList) throws BusinessException {
        for (Stock stock : stockList){
            if (stock.getQuantity().equals(0)){
                throw new BusinessException("Quantity of product cannot be 0");
            }
        }
        return stockRepository.saveAll(stockList);
    }

}
