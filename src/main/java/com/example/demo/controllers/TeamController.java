package com.example.demo.controllers;

import com.example.demo.models.dto.TeamDTO;
import com.example.demo.services.TeamService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services/teams")
public class TeamController {

    TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public List<TeamDTO> getAll(){
        return service.getAll();
    }


    @GetMapping(value = "/{id}")
    public Optional<TeamDTO> getById(@Valid @PathVariable ObjectId id){
        return service.getById(id);
    }

    @PostMapping(value = "/")
    public TeamDTO create(@Valid @RequestBody TeamDTO request){

        return service.save(request);

    }



}
