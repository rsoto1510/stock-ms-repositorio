package com.everis.stockms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor

public class ErrorDetailDto {
    private String message;
    private String dateTime;
}
