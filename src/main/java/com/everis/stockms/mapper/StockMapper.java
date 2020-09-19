package com.everis.stockms.mapper;

import com.everis.stockms.dto.FindByProductIdDto;
import com.everis.stockms.dto.SaveStockRequestDto;
import com.everis.stockms.dto.SaveStockResponseDto;
import com.everis.stockms.dto.StockDto;
import com.everis.stockms.entity.Stock;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);


    @Mapping(target = "total", ignore = true)
    public StockDto map(Stock stock);

    public List<StockDto> map (List<Stock> stocks);


    public FindByProductIdDto toFindByProductIdDto(Stock stock);


    public Stock toEntity(SaveStockRequestDto saveStockRequestDto);
    public SaveStockResponseDto toStockSaveResponseDto(Stock stock);

    @AfterMapping
    default void calcularTotal(Stock stock, @MappingTarget StockDto stockDto){
        stockDto.setTotal(toCalcularTotal());
    }
}
