package com.boot.demo.Movies.Controller;

import com.boot.demo.Movies.Entity.Movie;
import com.boot.demo.Movies.Service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movie")
    public List<Movie> fetchMovie(){
        return movieService.fetchMovie();
    }

    @GetMapping("/movie/{title}")
    public Movie fetchMovieOne(@PathVariable("title") String title){
        return movieService.fetchMovieOne(title);
    }

    @DeleteMapping("/movie/{title}")
    public String delMovie(@PathVariable("title") String title){
        movieService.delMovie(title);
        return "The Movie Directory has been Removed!";
    }

//    @GetMapping("/movie/{id}")
//    public ResponseEntity<Movie> fetchMovieOneId(@PathVariable("id") ObjectId Id){
//        Optional<Movie> movie = movieService.fetchMovieOneId(Id);
//        return movie.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @PutMapping("/movie/{title}")
    public Movie updateMovie(@PathVariable("title") String title,
                             @RequestBody Movie movie){
        return movieService.updateMovie(title, movie);
    }

}
