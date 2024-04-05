package org.example.asterixapi;


import lombok.Builder;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("characters")
public record Characters(String id,
                         String name,
                         @With
                         int age,
                         @With
                         String profession
) {
}
