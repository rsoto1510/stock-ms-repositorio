package com.everis.stockms.service;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.exception.ResourceNotFoundException;
import com.everis.stockms.repository.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestStockService {
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Test(expected = ResourceNotFoundException.class)
    public void testTotalStockException() throws ResourceNotFoundException {
        when(stockRepository.totalStock(any(Integer.class))).thenReturn(null);
        stockService.totalStock(1);
    }

    @Test
    public void testTotalStock() throws ResourceNotFoundException {
        Integer total = 3;
        when(stockRepository.totalStock(any(Integer.class))).thenReturn(total);
        FindByProductIdDto findByProductIdDto = new FindByProductIdDto();
        findByProductIdDto.setProductid(1);
        findByProductIdDto.setTotal(total);
        FindByProductIdDto result = stockService.totalStock(1);
        assertEquals(findByProductIdDto.getTotal(), result.getTotal());
    }
}
