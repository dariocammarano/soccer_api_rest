package com.example.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillsDTO {

    String name;
    Integer attacking;
    Integer midfield;
    Integer defense;
    Integer overall;
    Double rating;

}
