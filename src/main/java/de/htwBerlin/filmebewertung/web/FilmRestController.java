package de.htwBerlin.filmebewertung.web;

import de.htwBerlin.filmebewertung.web.api.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmRestController {

    private List<Film> filme;

    public FilmRestController() {
        filme = new ArrayList<>();
        filme.add(new Film(1, "Fluch der Karibik", 86, "Immer wieder lustig den Film zu gucken", "Hentsch"));
        filme.add(new Film(2, "Fast and the Furious", 89, "Nach ewiger Zeit mal wieder angeschaut und es ist immer noch so ein geiler Film", "Friedrich"));
    }

    @GetMapping(path = "/api/v1/filme")
    public ResponseEntity<List<Film>> fetchFilme(){
        return ResponseEntity.ok(filme);
    }
}
