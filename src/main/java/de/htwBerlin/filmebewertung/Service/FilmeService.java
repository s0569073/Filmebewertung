package de.htwBerlin.filmebewertung.Service;

import de.htwBerlin.filmebewertung.persistence.FilmeEntity;
import de.htwBerlin.filmebewertung.persistence.FilmeRepository;
import de.htwBerlin.filmebewertung.web.api.Film;
import de.htwBerlin.filmebewertung.web.api.FilmCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    private Film transformEntity(FilmeEntity filmeEntity){
        return new Film(filmeEntity.getId(),
                        filmeEntity.getFilmName(),
                        filmeEntity.getBewertung(),
                        filmeEntity.getKommentar(),
                        filmeEntity.getBewerter()
        );
    }
    public List<Film> findAll(){
        List<FilmeEntity> filme =filmeRepository.findAll();
        return filme.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Film findById(Long id){
        var filmEntity = filmeRepository.findById(id);
        return filmEntity.map(this::transformEntity).orElse(null);
    }
    public Film create(FilmCreateRequest request){
        var filmeEntity = new FilmeEntity(request.getFilmName(), request.getBewertung(), request.getKommentar(), request.getBewerter());
        filmeEntity = filmeRepository.save(filmeEntity);
        return transformEntity(filmeEntity);
    }
}
