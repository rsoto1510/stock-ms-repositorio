package com.everis.stockms.service;

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
    public Stock totalStock(Integer total) {
        return null;
    }

    @Override
    public List<Stock> listAll() {
        return (List<Stock>) stockRepository.findAll();
    }

    /*
        @Override
        public Stock customStockId(Integer id, Integer total) throws ResourceNotFoundException {
            return stockRepository.findCustomProductId(id,total);
        }
    */
    @Override
    public Stock save(Stock stock) throws BusinessException {
        if(stock.getQuantity() == 0){
            throw new BusinessException("Quantity of product cannot be 0");
        }
        return stockRepository.save(stock);
    }
}
