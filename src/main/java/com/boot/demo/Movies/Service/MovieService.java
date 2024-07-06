package com.boot.demo.Movies.Service;

import com.boot.demo.Movies.Entity.Movie;
import org.bson.types.ObjectId;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MovieService {

    public Movie saveMovie(Movie movie);

    public List<Movie> fetchMovie();

    public Movie fetchMovieOne(String title);

    public void delMovie(String title);

    //public Optional<Movie> fetchMovieOneId(ObjectId id);

    public Movie updateMovie(String title, Movie movie);
}
