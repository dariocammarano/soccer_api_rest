package com.example.demo.Converter;

import com.example.demo.models.api.TeamAPI;
import com.example.demo.models.dto.SkillsDTO;
import com.example.demo.models.dto.TeamDTO;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public TeamDTO convert(TeamAPI teamAPI){

        SkillsDTO statsDTO = SkillsDTO.builder()
                .attacking(teamAPI.getAttacking())
                .midfield(teamAPI.getMidfield())
                .defense(teamAPI.getDefense())
                .rating(teamAPI.getRating())
                .overall(teamAPI.getOverall())
                .build();

        TeamDTO teamDTO = TeamDTO.builder()
                .name(teamAPI.getName())
                .country(teamAPI.getCountry())
                .skills(statsDTO)
                .build();

        return teamDTO;
    }

}
