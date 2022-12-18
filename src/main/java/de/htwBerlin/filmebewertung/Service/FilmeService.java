package de.htwBerlin.filmebewertung.Service;

import de.htwBerlin.filmebewertung.persistence.FilmeEntity;
import de.htwBerlin.filmebewertung.persistence.FilmeRepository;
import de.htwBerlin.filmebewertung.web.api.Film;
import de.htwBerlin.filmebewertung.web.api.FilmManipulationRequest;
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
    public Film create(FilmManipulationRequest request){
        var filmeEntity = new FilmeEntity(request.getFilmName(), request.getBewertung(), request.getKommentar(), request.getBewerter());
        filmeEntity = filmeRepository.save(filmeEntity);
        return transformEntity(filmeEntity);
    }

    public Film update(Long id, FilmManipulationRequest request){
        var filmeEntityOptional = filmeRepository.findById(id);
        if(filmeEntityOptional.isEmpty()){
            return null;
        }

        var filmeEntity = filmeEntityOptional.get();

        filmeEntity.setFilmName(request.getFilmName());
        filmeEntity.setBewerter(request.getBewerter());
        filmeEntity.setBewertung(request.getBewertung());
        filmeEntity.setKommentar(request.getKommentar());

        filmeEntity = filmeRepository.save(filmeEntity);

        return transformEntity(filmeEntity);
    }

    public boolean deleteById(Long id){
        if(!filmeRepository.existsById(id)){
            return false;
        }

        filmeRepository.deleteById(id);
        return true;
    }
}
