package com.example.demo.domain;


import com.example.demo.entity.Stock;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class StockDTO {
    private Long stockId;
    private String itemName;
    private long itemPrice;
    private long itemStock;
    private MarketDTO market;

    public Stock toEntity(){
        return Stock.builder().itemName(itemName).itemPrice(itemPrice).itemStock(itemStock).build();
    }
}
