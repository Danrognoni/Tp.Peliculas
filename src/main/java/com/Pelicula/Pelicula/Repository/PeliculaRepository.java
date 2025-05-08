package com.Pelicula.Pelicula.Repository;

import com.Pelicula.Pelicula.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long>
{
    List<Pelicula> findByAnioLanzamiento(Integer anio);
    Boolean existsByTituloAndDirector(String Titulo,String director);

}
