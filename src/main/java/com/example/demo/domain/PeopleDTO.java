package com.example.demo.domain;

import com.example.demo.entity.People;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class PeopleDTO {
    private Long peopleId;
    private String name;
    private int money;
    private int age;
    private int averageMoneyConsume;

    public People toEntity(){
        return People.builder().peopleAge(age).peopleMoney(money).peopleName(name).build();
    }

}
