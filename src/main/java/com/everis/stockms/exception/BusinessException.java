package com.everis.stockms.exception;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class BusinessException extends Exception{

    private static final long serialVersionUID = 1L;

    private String message;
    private String dateTime;

    static String obtenerFechaYHoraActual() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }

    public BusinessException(String message){
        this.message = message;
        this.dateTime = obtenerFechaYHoraActual();
    }
}
