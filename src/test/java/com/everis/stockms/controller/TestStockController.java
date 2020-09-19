package com.everis.stockms.controller;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.dto.SaveStockRequestDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.entity.Stock;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;
import com.everis.stockms.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestStockController {

    @InjectMocks
    private StockController stockController;

    @Mock
    private StockService stockService;

    @Test
    public void TestTotalStock() throws ResourceNotFoundException {
        FindByProductIdDto findByProductIdDto = new FindByProductIdDto();
        findByProductIdDto.setProductid(1);
        findByProductIdDto.setTotal(8);
        when(stockService.totalStock(any(Integer.class))).thenReturn(findByProductIdDto);

        FindByProductIdDto total = stockController.customStockId(1);
        assertEquals(findByProductIdDto.getProductid(),total.getProductid());
        assertEquals(findByProductIdDto.getTotal(),total.getTotal());

    }

    @Test
    public void TestSave()throws BusinessException{
        Stock saveStock = new Stock();
        saveStock.setId(1);
        saveStock.setProductid(1);
        saveStock.setWarehouseid(1);
        saveStock.setQuantity(1);

        List<Stock> stockList = new ArrayList<>();
        stockList.add(saveStock);
        when(stockService.save(any(ArrayList.class))).thenReturn(stockList);

        SaveStockRequestDto saveStockRequestDto = new SaveStockRequestDto();
        saveStockRequestDto.setProductid(1);
        saveStockRequestDto.setWarehouseid(1);
        saveStockRequestDto.setQuantity(1);
        List<SaveStockRequestDto> saveStockRequestDtoList = new ArrayList<>();
        saveStockRequestDtoList.add(saveStockRequestDto);

        ResponseEntity<List<SaveStockResponseDto>> resultado = stockController.saveStock(saveStockRequestDtoList);
        assertNotNull(resultado);
        assertEquals(saveStockRequestDtoList.size(),resultado.getBody().size());
        assertEquals(saveStockRequestDto.getProductid(),resultado.getBody().get(0).getProductid());
        assertEquals(1,resultado.getBody().get(0).getId());

    }
}
