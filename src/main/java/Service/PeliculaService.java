package Service;

import Model.Pelicula;
import Repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import Exception.TittleAndDIrectorExist;
import Exception.DocumentaryBelow1920;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private PeliculaRepository movierepo;
    @Autowired
    public PeliculaService(PeliculaRepository movierepo) {
        this.movierepo = movierepo;
    }

    public Pelicula crearPelicula(@Valid Pelicula movie)   {
        if(movierepo.existByTituloyDirecto(movie.getTitulo(),movie.getDirector())){
          throw new TittleAndDIrectorExist("No se admiten titulos y directores repetidos");
        }
        if(movie.getGenero().equalsIgnoreCase("documental")&movie.getAnioLanzamiento()<1920){
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
        return movierepo.findByanio(anio);
    }

}
