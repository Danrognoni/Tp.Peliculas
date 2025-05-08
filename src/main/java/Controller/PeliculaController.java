package Controller;

import Model.Pelicula;
import Service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Peliculas")
public class PeliculaController {

    private PeliculaService service;
    @Autowired
    public PeliculaController(PeliculaService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> crearPelicula(@Valid @RequestBody Pelicula pelicula) {
        return new ResponseEntity<>(service.crearPelicula(pelicula),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> listarPeliculas(){
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping
    public ResponseEntity<?> obtenerPorId (@Valid @PathVariable Long Id){
        return service.buscarPorId(Id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<?> buscarPoranio (@Valid @PathVariable Integer anio){
        return ResponseEntity.ok(service.buscarPorAnio(anio));
    }

}
