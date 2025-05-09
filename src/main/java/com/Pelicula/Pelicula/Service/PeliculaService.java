package com.Pelicula.Pelicula.Service;

import com.Pelicula.Pelicula.Model.Pelicula;
import com.Pelicula.Pelicula.PeliculaApplication;
import com.Pelicula.Pelicula.Repository.PeliculaRepository;
import com.Pelicula.Pelicula.Validation.PeliculaValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Pelicula.Pelicula.Exception.TittleAndDIrectorExist;
import com.Pelicula.Pelicula.Exception.DocumentaryBelow1920;
import com.Pelicula.Pelicula.Exception.BusinessException;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private PeliculaRepository movierepo;
    @Autowired
    public PeliculaService(PeliculaRepository movierepo) {
        this.movierepo = movierepo;
    }

    public Pelicula crearPelicula( Pelicula movie)   {
        PeliculaValidator.validarAnio(movie.getAnioLanzamiento());
        PeliculaValidator.validarTituloYDirector(movie.getTitulo(),movie.getDirector(),movierepo);
        if(movie.getGenero().equalsIgnoreCase("documental") && movie.getAnioLanzamiento()<1920){
            throw new DocumentaryBelow1920("no se permiten documentales anteior a 1920");
        }
        return movierepo.save(movie);
    }

    public Optional<Pelicula> buscarPorId (@Valid Long id){
        return movierepo.findById(id);
    }
    public List<Pelicula> listar(){
        return movierepo.findAll();
    }
    public List<Pelicula> buscarPorAnio(@Valid Integer anio){
        return movierepo.findByAnioLanzamiento(anio);
    }

}
