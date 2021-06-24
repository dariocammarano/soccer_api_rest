package com.example.demo.controllers;

import com.example.demo.models.api.LeagueAPI;
import com.example.demo.models.dto.LeagueDTO;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.LeagueService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services/leagues")
public class LeagueController {

    LeagueService service;

    public LeagueController(LeagueService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public List<LeagueDTO> getAll(){

        return service.getAll();

    }

    @PostMapping(value = "/")
    public LeagueDTO create(@Valid @RequestBody LeagueAPI request){

        return service.save(request);

    }

}
