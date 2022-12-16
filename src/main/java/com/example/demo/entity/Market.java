package com.example.demo.entity;


import com.example.demo.domain.MarketDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MARKET")
@Getter @ToString
@NoArgsConstructor
public class Market {
    @Id @GeneratedValue
    private Long marketId;
    private String marketName;
    private String marketPlace;

    @Builder
    public Market(String marketName, String marketPlace) {
        this.marketName = marketName;
        this.marketPlace = marketPlace;
    }

    public void update(MarketDTO marketDTO){
        this.marketName = marketDTO.getMarketName();
        this.marketPlace=marketDTO.getMarketPlace();
    }

    public void update(String marketName){
        this.marketName = marketName;
    }

    public void updatePlace(String marketPlace){
        this.marketPlace=marketPlace;
    }

    public MarketDTO toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, MarketDTO.class);
    }

}
