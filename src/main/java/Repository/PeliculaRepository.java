package Repository;

import Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long>
{
    List<Pelicula> findByAnioLanzamiento(Integer anio);
    List<Pelicula>findByTituloyDirecto(String Titulo,String director);
}
