package com.example.demo.services;

import com.example.demo.Converter.Converter;
import com.example.demo.enums.CountryEnum;
import com.example.demo.enums.LeaguesEnum;
import com.example.demo.models.api.TeamAPI;
import com.example.demo.models.dto.LeagueDTO;
import com.example.demo.models.dto.TeamDTO;
import com.example.demo.repository.LeagueRepository;
import com.example.demo.models.api.LeagueAPI;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueService {

    LeagueRepository repository;
    TeamService teamService;
    CountryService countryService;
    Converter converter;

    public LeagueService(LeagueRepository repository, TeamService teamService, CountryService countryService, Converter converter) {
        this.repository = repository;
        this.teamService = teamService;
        this.countryService = countryService;
        this.converter = converter;
    }


    public List<LeagueDTO> getAll (){
        return repository.findAll();
    }

    public LeagueDTO save(LeagueAPI request){
        List<ObjectId> teams = new ArrayList<>();
        LeaguesEnum league = LeaguesEnum.getLeagueByName(request.getName());

        request.getTeams().forEach(team -> { teamService.prepareTeamDTOAndSave(request, teams, team); });

        LeagueDTO leagueDTO = LeagueDTO.builder()
                .name(request.getName())
                .country(countryService.getCountryByLeague(league))
                .teams(teams)
                .build();

        return upsert(leagueDTO);
    }

    private LeagueDTO upsert(LeagueDTO leagueDTO) {
        LeagueDTO leagueFromDatabase = findByNameAndCountry(leagueDTO.getName(), leagueDTO.getCountry());

        if (!ObjectUtils.isEmpty(leagueFromDatabase)){
            leagueDTO.set_id(leagueFromDatabase.get_id());
        }

        return repository.save(leagueDTO);
    }

    public LeagueDTO findByNameAndCountry (String name, CountryEnum country){
        return repository.findByNameAndCountry(name, country);
    }

}
