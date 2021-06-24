package com.example.demo.services;

import com.example.demo.enums.CountryEnum;
import com.example.demo.enums.LeaguesEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CountryService {

    public CountryEnum getCountryByLeague(LeaguesEnum league){

        Optional<CountryEnum> country = Arrays.asList(CountryEnum.values()).stream().filter(c -> c.getLeagues().contains(league)).findFirst();

        if (country.isPresent()){
            return country.get();
        }

        return null;

    }

}
