package com.boot.demo.Movies.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movie-api")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Movie {

    @Id
    private ObjectId Id;

    private String title;
    private String releaseDate;
    private List<String> genres;
    private String poster;
}
