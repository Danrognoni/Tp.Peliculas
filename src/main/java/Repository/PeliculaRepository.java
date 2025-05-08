package Repository;

import Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long>
{
    List<Pelicula> findByAnioLanzamiento(Integer anio);
    Boolean existByTituloyDirecto(String Titulo,String director);
    List<Pelicula> findByanio(Integer anio);
}
