package com.example.demo.models.dto;

import com.example.demo.enums.CountryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "teams")
public class TeamDTO {

    @Id
    ObjectId _id;
    String name;
    SkillsDTO skills;
    CountryEnum country;
    UserDTO user;

}
