package com.example.demo.entity;

import com.example.demo.domain.MarketDTO;
import com.example.demo.domain.PeopleDTO;
import com.example.demo.domain.StockDTO;
import com.example.demo.repository.MarketRepository;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(false)
public class ModelMapperTest {
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    PeopleRepository peopleRepository;



    @Test
    public void saveTest(){
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setMarketName("바나프레소");
        marketDTO.setMarketPlace("서울시 역삼역 3번출구");

        marketRepository.save(marketDTO.toEntity());

    }

    @Test
    public void stockSaveTest() {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setItemName("아이스티");
        stockDTO.setItemPrice(3500l);
        stockDTO.setItemStock(520l);
        Stock entity = stockDTO.toEntity();
        Optional<Market> marketOptional = marketRepository.findById(1l);
        if (marketOptional.isPresent()) {
            Market market = marketOptional.get();
            entity.setMarket(market);
        }

        stockRepository.save(entity);

    }


    @Test
    public void peopleSaveTest(){
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setName("dawn");
        peopleDTO.setMoney(500000000);
        peopleDTO.setAge(27);

        peopleRepository.save(peopleDTO.toEntity());
    }

    @Test
    public void modelMapperTest(){
        Optional<Market> marketOptional = marketRepository.findById(1l);
        if(marketOptional.isPresent()){
            Market market = marketOptional.get();


            MarketDTO dto = market.toDTO();

            log.info(dto.toString());
        }
    }



    @Test
    public void stockDTOMapperTest(){
        Optional<Stock> optionalStock = stockRepository.findById(2l);
        if(optionalStock.isPresent()){
            Stock stock = optionalStock.get();

            StockDTO dto = stock.toDTO();

            log.info(dto.toString());

        }
    }

    @Test
    public void peopleDTOMapperTest(){
        Optional<People> optionalPeople = peopleRepository.findById(1l);
        if(optionalPeople.isPresent()){
            People people = optionalPeople.get();

            PeopleDTO dto = people.toDTO();

            log.info(dto.toString());
        }
    }

}
