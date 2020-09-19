package com.everis.stockms.controller;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.dto.SaveStockRequestDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.dto.StockDto;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;
import com.everis.stockms.mapper.StockMapper;
import com.everis.stockms.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;
/*
    @GetMapping("stock/{productId}")
    public FindByProductIdDto customStockId(@PathVariable("productId") Integer id) throws ResourceNotFoundException{
        return StockMapper.INSTANCE.map(stockService.customStockId(id,total));
    }*/

    @GetMapping("stock/list")
    public List<StockDto> list() {
        return StockMapper.INSTANCE.map(stockService.listAll());
    }

    @PostMapping("/stock")
    public SaveStockResponseDto save(@RequestBody SaveStockRequestDto saveStockRequestDto) throws BusinessException{
        return StockMapper.INSTANCE
                .toStockSaveResponseDto(stockService.save(StockMapper.INSTANCE.toEntity(saveStockRequestDto)));
    }
}

