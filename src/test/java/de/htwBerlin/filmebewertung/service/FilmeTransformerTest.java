package de.htwBerlin.filmebewertung.service;

import de.htwBerlin.filmebewertung.Service.FilmTransformer;
import de.htwBerlin.filmebewertung.persistence.FilmeEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class FilmeTransformerTest implements WithAssertions {

    private final FilmTransformer underTest = new FilmTransformer();

    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_transform_person_entity_to_person() {
        // given
        var filmEntity = Mockito.mock(FilmeEntity.class);
        doReturn(111L).when(filmEntity).getId();
        doReturn("Testfilm").when(filmEntity).getFilmName();
        doReturn("Mustermann").when(filmEntity).getBewerter();
        doReturn(95).when(filmEntity).getBewertung();
        doReturn("Test für ein Kommentar").when(filmEntity).getKommentar();

        // when
        var result = underTest.transformEntity(filmEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getFilmName()).isEqualTo("Testfilm");
        assertThat(result.getBewerter()).isEqualTo("Mustermann");
        assertThat(result.getBewertung()).isEqualTo(95);
        assertThat(result.getKommentar()).isEqualTo("Test für ein Kommentar");
    }
}
