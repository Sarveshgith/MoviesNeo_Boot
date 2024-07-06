package com.boot.demo.Movies.Repository;

import com.boot.demo.Movies.Entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends MongoRepository<Movie, Long> {

    public Movie findByTitleIgnoreCase(String title);

    public void deleteByTitleIgnoreCase(String title);

//    public Optional<Movie> findById(ObjectId id);
}
