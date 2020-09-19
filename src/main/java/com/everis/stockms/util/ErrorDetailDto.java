package com.everis.stockms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class ErrorDetailDto {
    private String message;
    private String dateTime;
}