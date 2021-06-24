package com.example.demo.repository;

import com.example.demo.enums.CountryEnum;
import com.example.demo.models.dto.LeagueDTO;
import com.example.demo.models.dto.TeamDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends MongoRepository<LeagueDTO, ObjectId> {

    public LeagueDTO findByNameAndCountry(String name, CountryEnum country);

}
