package de.htwBerlin.filmebewertung.persistence;

import de.htwBerlin.filmebewertung.web.api.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {

    List<FilmeEntity> findAllByFilmName(String filmName);

}
