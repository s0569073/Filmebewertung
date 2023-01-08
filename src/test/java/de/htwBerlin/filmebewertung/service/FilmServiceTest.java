package de.htwBerlin.filmebewertung.service;

import de.htwBerlin.filmebewertung.Service.FilmeService;
import de.htwBerlin.filmebewertung.persistence.FilmeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    @Mock
    private FilmeRepository repository;

    @InjectMocks
    private FilmeService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void delete_sucessful() {

        Long givenId = 111L;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("film does not exist")
    void film_does_not_exist() {
        // given
        Long givenId = 111L;
        doReturn(false).when(repository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
