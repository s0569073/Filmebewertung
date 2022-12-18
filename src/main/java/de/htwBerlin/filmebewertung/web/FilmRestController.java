package de.htwBerlin.filmebewertung.web;

import de.htwBerlin.filmebewertung.Service.FilmeService;
import de.htwBerlin.filmebewertung.web.api.Film;
import de.htwBerlin.filmebewertung.web.api.FilmManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<Void> createFilm(@RequestBody FilmManipulationRequest request) throws URISyntaxException {
        var film = filmeService.create(request);
        URI url = new URI("/api/v1/filme/" + film.getId());
        return ResponseEntity.created(url).build();
    }

    @PutMapping(path = "/api/v1/filme/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody FilmManipulationRequest request) {
        var film = filmeService.update(id, request);
        return film != null ? ResponseEntity.ok(film) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/filme/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        boolean successful = filmeService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
