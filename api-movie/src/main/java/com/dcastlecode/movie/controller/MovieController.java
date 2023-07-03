package com.dcastlecode.movie.controller;

import com.dcastlecode.movie.model.Movie;
import com.dcastlecode.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;



    @GetMapping
    public List<Movie> getAllMovie(){
        return movieService.getMovie();

    }
    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieById(@PathVariable Long id){
        return  movieService.getMovieById(id);
    }
    @GetMapping("/{genre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMovieByGenre(@PathVariable String genre){
        return movieService.getMovieByGenero(genre);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Movie save(@Validated  @RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovie(@RequestBody Movie movie,@PathVariable("id")Long id){
        return movieService.updateMovie(movie,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteMovie(@PathVariable("id") Long id){
         movieService.deleteMovie(id);
         return "Deleted Successfully";
    }
}
