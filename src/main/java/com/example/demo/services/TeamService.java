package com.example.demo.services;

import com.example.demo.Converter.Converter;
import com.example.demo.enums.CountryEnum;
import com.example.demo.models.api.LeagueAPI;
import com.example.demo.models.api.TeamAPI;
import com.example.demo.models.dto.TeamDTO;
import com.example.demo.repository.TeamRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    TeamRepository repository;
    CountryService countryService;
    Converter converter;

    public TeamService(TeamRepository repository, CountryService countryService, Converter converter) {
        this.repository = repository;
        this.countryService = countryService;
        this.converter = converter;
    }

    public TeamDTO findByNameAndCountry (String name, CountryEnum country){
        return repository.findByNameAndCountry(name, country);
    }

    public List<TeamDTO> getAll(){
        return repository.findAll();
    }

    public TeamDTO save(TeamDTO request) {
        return repository.save(request);
    }

    public void prepareTeamDTOAndSave(LeagueAPI request, List<ObjectId> teams, TeamAPI team) {
        TeamDTO teamDTO = converter.convert(team);
        teamDTO = upsert(teamDTO);

        teams.add(teamDTO.get_id());
    }

    //PK Name - Country
    private TeamDTO upsert(TeamDTO teamDTO) {
        TeamDTO teamFromDatabase = findByNameAndCountry(teamDTO.getName(), teamDTO.getCountry());

        if (!ObjectUtils.isEmpty(teamFromDatabase)){
            teamDTO.set_id(teamFromDatabase.get_id());
        }

        return save(teamDTO);
    }

    public Optional<TeamDTO> getById(ObjectId id) {
        return repository.findById(id);
    }
}
