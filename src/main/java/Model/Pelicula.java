package Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.lang.NonNull;

@Entity
@Table (name = "Peliculas")

public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    @Size(min = 2, max = 100)
    private String titulo;

    @NotNull
    private String director;

    @Min(1895)
    @Max(value = 2025)
    private int anioLanzamiento;

    private String genero;

    public Pelicula(long id, String titulo, String director, int anioLanzamiento, String genero) {
        Id = id;
        this.titulo = titulo;
        this.director = director;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
    }
    public Pelicula() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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
