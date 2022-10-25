package de.htwBerlin.filmebewertung.web;

import de.htwBerlin.filmebewertung.Service.FilmeService;
import de.htwBerlin.filmebewertung.persistence.FilmeRepository;
import de.htwBerlin.filmebewertung.web.api.Film;
import de.htwBerlin.filmebewertung.web.api.FilmCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmRestController {

    private  final FilmeService filmeService;

    public FilmRestController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping(path = "/api/v1/filme")
    public ResponseEntity<List<Film>> fetchFilme(){
        return ResponseEntity.ok(filmeService.findAll());
    }

    @GetMapping(path = "/api/v1/filme/{id}")
    public ResponseEntity<Film> fetchFilmById(@PathVariable Long id){
        var film = filmeService.findById(id);
        return film != null? ResponseEntity.ok(film) : ResponseEntity.notFound().build();
    }
    @PostMapping(path = "/api/v1/filme")
    public ResponseEntity<Void> createFilm(@RequestBody FilmCreateRequest request) throws URISyntaxException {
        var film = filmeService.create(request);
        URI url = new URI("/api/v1/filme/" + film.getId());
        return ResponseEntity.created(url).build();
    }
}
