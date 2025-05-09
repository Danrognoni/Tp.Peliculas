package com.Pelicula.Pelicula.Validation;

import com.Pelicula.Pelicula.Exception.BusinessException;
import com.Pelicula.Pelicula.Exception.TittleAndDIrectorExist;
import com.Pelicula.Pelicula.Model.Pelicula;
import com.Pelicula.Pelicula.Repository.PeliculaRepository;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.Time;
import java.time.Year;

public class PeliculaValidator {

    public static void validarAnio(Integer anio) {
        int actual = Year.now().getValue();
       if(anio<1985 || anio>actual+2){
           throw  new BusinessException("La pelicula tiene que estar entre 1985 y " + (actual+2));
       }
    }

    public static void validarTituloYDirector(String titulo, String director, PeliculaRepository repo) {
        if (repo.existsByTituloAndDirector(titulo, director)) {
            throw new BusinessException("Ya existe una película con ese título y director");
        }
    }
}
