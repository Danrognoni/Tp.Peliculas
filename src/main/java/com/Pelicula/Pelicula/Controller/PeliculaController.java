package com.Pelicula.Pelicula.Controller;

import com.Pelicula.Pelicula.Model.Pelicula;
import com.Pelicula.Pelicula.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private PeliculaService service;
    @Autowired
    public PeliculaController(PeliculaService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearPelicula(pelicula));
    }
    @GetMapping
    public ResponseEntity<?> listarPeliculas(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId (@PathVariable Long id){
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<?> buscarPoranio (@PathVariable Integer anio){
        return ResponseEntity.ok(service.buscarPorAnio(anio));
    }

}
