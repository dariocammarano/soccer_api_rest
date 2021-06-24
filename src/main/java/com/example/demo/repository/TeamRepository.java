package com.example.demo.repository;

import com.example.demo.enums.CountryEnum;
import com.example.demo.models.dto.TeamDTO;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends MongoRepository<TeamDTO, ObjectId> {
    public TeamDTO findByNameAndCountry(String name, CountryEnum country);
}
