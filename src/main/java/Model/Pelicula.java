package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.Year;

public class Pelicula {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El título no puede ser nulo")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres")
    private String titulo;

    @NotNull(message = "El director no puede ser nulo")
    private String director;

    @Min(value = 1895, message = "El año de lanzamiento no puede ser menor a 1895")
    private int anioLanzamiento;

    private String genero; // opcional




    // Constructor vacío (requerido por JPA)
    public Pelicula() {}

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
