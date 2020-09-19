package com.everis.stockms.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StockDto {

    private Integer id;
    private Integer productid;
    private Integer warehouseid;
    private Integer quantity;
    private Integer total;
}
