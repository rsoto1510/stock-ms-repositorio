package com.everis.stockms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveStockRequestDto {
    private Integer productid;
    private Integer warehouseid;
    private Integer quantity;
}
