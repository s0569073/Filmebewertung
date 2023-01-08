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
    private final FilmTransformer filmTransformer;

    public FilmeService(FilmeRepository filmeRepository, FilmTransformer filmTransformer) {

        this.filmeRepository = filmeRepository;
        this.filmTransformer = filmTransformer;
    }

    public List<Film> findAll(){
        List<FilmeEntity> filme =filmeRepository.findAll();
        return filme.stream()
                .map(filmTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Film findById(Long id){
        var filmEntity = filmeRepository.findById(id);
        return filmEntity.map(filmTransformer::transformEntity).orElse(null);
    }
    public Film create(FilmManipulationRequest request){
        var filmeEntity = new FilmeEntity(request.getFilmName(), request.getBewertung(), request.getKommentar(), request.getBewerter());
        filmeEntity = filmeRepository.save(filmeEntity);
        return filmTransformer.transformEntity(filmeEntity);
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

        return filmTransformer.transformEntity(filmeEntity);
    }

    public boolean deleteById(Long id){
        if(!filmeRepository.existsById(id)){
            return false;
        }

        filmeRepository.deleteById(id);
        return true;
    }
}
