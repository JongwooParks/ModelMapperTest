package com.example.demo.domain;


import com.example.demo.entity.Market;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class MarketDTO {
    private Long marketId;
    private String marketName;
    private String marketPlace;

    public Market toEntity(){
        return Market.builder().marketName(marketName).marketPlace(marketPlace).build();
    }


}
