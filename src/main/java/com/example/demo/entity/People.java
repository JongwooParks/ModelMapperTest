package com.example.demo.entity;

import com.example.demo.domain.PeopleDTO;
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
@Table(name="PEOPLE")
@ToString @Getter
@NoArgsConstructor
public class People {
    @Id @GeneratedValue
    private Long peopleId;

    private String peopleName;
    private int peopleAge;
    private long peopleMoney;

    @Builder
    public People(String peopleName, int peopleAge, long peopleMoney) {
        this.peopleName = peopleName;
        this.peopleAge = peopleAge;
        this.peopleMoney = peopleMoney;
    }

    public void updatePeopleName(String name){
        this.peopleName = peopleName;
    }

    public void updatePeopleAge(int age){
        this.peopleAge = age;
    }

    public void setPeopleMoney(long money){
        this.peopleMoney = this.peopleMoney+money;
    }

    public PeopleDTO toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(People.class,PeopleDTO.class).addMappings(mapper->{
            mapper.map(people->people.getPeopleMoney()/10, PeopleDTO::setAverageMoneyConsume);});
        return modelMapper.map(this,PeopleDTO.class);

    }
}
