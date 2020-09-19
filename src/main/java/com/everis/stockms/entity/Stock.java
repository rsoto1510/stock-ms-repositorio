package com.everis.stockms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Stock")

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column
    private Integer productid;
    @Column
    private Integer warehouseid;
    @Column
    private Integer quantity;

}
