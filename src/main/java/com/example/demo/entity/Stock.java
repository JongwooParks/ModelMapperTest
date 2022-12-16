package com.example.demo.entity;


import com.example.demo.domain.StockDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name="STOCK")
@Getter @ToString
@NoArgsConstructor
public class Stock {
    @Id @GeneratedValue
    private Long stockId;
    private String itemName;
    private long itemPrice;
    private long itemStock;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MARKET_ID")
    private Market market;

    public void setMarket(Market market){
        this.market = market;
    }

    @Builder
    public Stock(String itemName, long itemPrice, long itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public void update(StockDTO stockDTO){
        this.itemName= stockDTO.getItemName();
        this.itemPrice=stockDTO.getItemPrice();
        this.itemStock=stockDTO.getItemStock();
    }

    public void updateName(String itemName){
        this.itemName = itemName;
    }
    public void updateStock(long itemStock){
        this.itemStock = itemStock;
    }
    public void updatePrice(long itemPrice){
        this.itemPrice = itemPrice;
    }

    public StockDTO toDTO(){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this,StockDTO.class);

    }
}
