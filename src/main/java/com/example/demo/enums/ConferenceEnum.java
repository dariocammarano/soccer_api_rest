package com.example.demo.enums;

import java.util.Arrays;
import java.util.List;

public enum ConferenceEnum {

    ALL(Arrays.asList(CountryEnum.values())),
    FIFA(Arrays.asList(CountryEnum.values())),
    INTERNATIONAL(Arrays.asList(CountryEnum.values())),
    UEFA(Arrays.asList(CountryEnum.SPAIN, CountryEnum.ITALY, CountryEnum.ENGLAND)),
    CONMEBOL(Arrays.asList()),
    CONCACAF(Arrays.asList());

    List<CountryEnum> countries;

    ConferenceEnum(List<CountryEnum> countries) {
        this.countries = countries;
    }

    public List<CountryEnum> getCountries() {
        return countries;
    }
}
