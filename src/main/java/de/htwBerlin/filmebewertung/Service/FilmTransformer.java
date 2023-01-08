package de.htwBerlin.filmebewertung.Service;

import de.htwBerlin.filmebewertung.persistence.FilmeEntity;
import de.htwBerlin.filmebewertung.web.api.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmTransformer {

    public Film transformEntity(FilmeEntity filmeEntity) {
        return new Film(filmeEntity.getId(),
                filmeEntity.getFilmName(),
                filmeEntity.getBewertung(),
                filmeEntity.getKommentar(),
                filmeEntity.getBewerter()
        );
    }
}
