package com.example.demo.enums;

import java.util.Arrays;
import java.util.Optional;

public enum LeaguesEnum {

    ALL("ALL", 0),
    PREMIER_LEAGUE("PREMIER LEAGUE", 13),
    LA_LIGA_SANTANDER("LaLiga Santander", 53),
    SERIE_A_TIM("Serie A TIM", 31)
    ;

    String name;
    Integer scraperId;

    public String getName() {
        return name;
    }

    public Integer getScraperId() {
        return scraperId;
    }

    public static LeaguesEnum getLeagueByName(String name){
        Optional<LeaguesEnum> league = Arrays.asList(LeaguesEnum.values()).stream().filter(l -> l.getName().equals(name)).findFirst();
        if (league.isPresent()){
            return league.get();
        }
        return null;
    }

    LeaguesEnum(String name, Integer scraperId) {
        this.name = name;
        this.scraperId = scraperId;
    }

}
