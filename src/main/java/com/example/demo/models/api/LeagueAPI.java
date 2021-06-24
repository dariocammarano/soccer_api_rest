package com.example.demo.models.api;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeagueAPI {

    @NotEmpty
    String name;

    @NotNull
    List<TeamAPI> teams;

}
