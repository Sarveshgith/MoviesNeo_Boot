package com.boot.demo.Movies.Service;

import com.boot.demo.Movies.Entity.Movie;
import com.boot.demo.Movies.Repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public List<Movie> fetchMovie() {
        return movieRepo.findAll();
    }

    @Override
    public Movie fetchMovieOne(String title) {
        return movieRepo.findByTitleIgnoreCase(title);
    }

    @Override
    public void delMovie(String title) {
        movieRepo.deleteByTitleIgnoreCase(title);
    }

//    @Override
//    public Optional<Movie> fetchMovieOneId(ObjectId id) {
//        ObjectId obj = new ObjectId(id);
//        return movieRepo.findById(id);
//    }

    @Override
    public Movie updateMovie(String title, Movie movie) {
        Movie tempmovie = movieRepo.findByTitleIgnoreCase(title);

        if(Objects.nonNull(movie.getReleaseDate()) &&
        !"".equalsIgnoreCase(movie.getReleaseDate())){
            tempmovie.setReleaseDate(movie.getReleaseDate());
        }

        if(Objects.nonNull(movie.getGenres())){
            tempmovie.setGenres(movie.getGenres());
        }

        if(Objects.nonNull(movie.getPoster()) &&
                !"".equalsIgnoreCase(movie.getPoster())){
            tempmovie.setPoster(movie.getPoster());
        }

       return movieRepo.save(tempmovie);
    }
}
