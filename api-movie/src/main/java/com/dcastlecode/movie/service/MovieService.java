package com.dcastlecode.movie.service;

import com.dcastlecode.movie.model.Movie;
import com.dcastlecode.movie.repository.MovieRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class MovieService {

    @Autowired
    private MovieRespository movieRespository;


    // LISTAR PELICULAS
   public List<Movie> getMovie(){
        return movieRespository.findAll();
    }
    //BUSCAR POR ID
   public Movie getMovieById(Long id){
        return movieRespository.findById(id).orElse(null);
    }
    //BUSCAR POR GENERO
    public List<Movie> getMovieByGenero(String genre){
        return movieRespository.findByGenre(genre);
    }
    // GUARDAR MOVIE
    public Movie saveMovie(Movie movie){
        return movieRespository.save(movie);
    }
    //ACTUALIZAR
    public Movie updateMovie(Movie movie,Long id){
       Movie movie1 = movieRespository.findById(id).get();
       if (Objects.nonNull(movie.getName())&& !"".equalsIgnoreCase(movie.getName())){
           movie1.setName(movie.getName());
       }
        if (Objects.nonNull(movie.getGenre()) && !"".equalsIgnoreCase(movie.getGenre())) {
            movie1.setGenre(movie.getGenre());

        }
        if (Objects.nonNull(movie.getUrlStream())&&!"".equalsIgnoreCase(movie.getUrlStream())){
            movie1.setUrlStream(movie.getUrlStream());
        }
        return movieRespository.save(movie1);
    }
    //DELETE
    public  void deleteMovie(Long id){
       movieRespository.deleteById(id);
    }

}
