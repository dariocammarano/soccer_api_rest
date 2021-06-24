package com.example.demo.enums;

import java.util.Arrays;
import java.util.List;

public enum CountryEnum {

    ALL(Arrays.asList(LeaguesEnum.values())),
    UNKNOWN(Arrays.asList()),
    SPAIN(Arrays.asList(LeaguesEnum.LA_LIGA_SANTANDER)),
    ENGLAND(Arrays.asList(LeaguesEnum.PREMIER_LEAGUE)),
    ITALY(Arrays.asList(LeaguesEnum.SERIE_A_TIM))
    ;


    List<LeaguesEnum> leagues;

    public List<LeaguesEnum> getLeagues() {
        return leagues;
    }

    CountryEnum(List<LeaguesEnum> leagues) {
        this.leagues = leagues;
    }

}
