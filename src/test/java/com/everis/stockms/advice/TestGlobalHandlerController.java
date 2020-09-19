package com.everis.stockms.advice;

import com.everis.stockms.controller.advice.GlobalHandlerControllerAdvice;
import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;
import com.everis.stockms.util.ErrorDetailDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestGlobalHandlerController {
    @InjectMocks
    private GlobalHandlerControllerAdvice advice;

    @Test
    public void testResourceNoContentException(){
        assertNotNull(advice.resourceNotFoundException(new ResourceNotFoundException()));
    }

    @Test
    public void testBusinessException(){
        BusinessException exception = new BusinessException("error");
        ResponseEntity<ErrorDetailDto> result = advice.businessException(exception);
        assertNotNull(result);
        assertEquals(exception.getMessage(),result.getBody().getMessage());
        assertEquals(exception.getDateTime(),result.getBody().getDateTime());
    }
}
