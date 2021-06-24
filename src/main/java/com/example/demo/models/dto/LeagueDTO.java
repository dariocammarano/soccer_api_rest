package com.example.demo.models.dto;

import com.example.demo.enums.CountryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "leagues")
public class LeagueDTO {

    @Id
    ObjectId _id;

    @NotEmpty
    String name;

    @NotNull
    List<ObjectId> teams;

    CountryEnum country;


}
