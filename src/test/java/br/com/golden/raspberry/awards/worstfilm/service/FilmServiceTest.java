package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.builder.FilmDtoBuilder;
import br.com.golden.raspberry.awards.worstfilm.builder.FilmModelBuilder;
import br.com.golden.raspberry.awards.worstfilm.dto.ResponseDTO;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import br.com.golden.raspberry.awards.worstfilm.repository.FilmRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;


@RunWith(MockitoJUnitRunner.class)
public class FilmServiceTest {
    @InjectMocks
    private FilmsService filmsService;
    @Mock
    private ResourcesService resourcesService;
    @Mock
    private FilmRepository repository;

    @Before
    public void setup(){

    }

    @Test
    public void when_call_save_film_in_database_should_be_ok() throws NoSuchFileCSVException {
        Mockito.when(resourcesService.getFilmDtoFromCSV()).thenReturn(FilmDtoBuilder.getListFilmDto());
        this.filmsService.saveFilmInDatabase();
    }

    @Test
    public void when_call_save_film_in_database_should_be_not_ok() {
        try {
            Mockito.when(resourcesService.getFilmDtoFromCSV()).thenThrow( new NoSuchFileCSVException());
            this.filmsService.saveFilmInDatabase();
        }catch (NoSuchFileCSVException e){
            Assertions.assertEquals( "Please verify the cvs file is present or the path is correct", e.getMessage());
        }
    }

    @Test
    public void when_call_get_winners_should_be_ok(){
        Mockito.when(repository.findAll()).thenReturn(FilmModelBuilder.getListFilmModel());
        final Map<String, List<ResponseDTO>> winners = this.filmsService.getWinners();
        Assertions.assertNotNull(winners);
        Assertions.assertEquals( "Producer 2", winners.get("min").get(0).getProducer());
        Assertions.assertEquals( "Producer 3", winners.get("min").get(1).getProducer());
        Assertions.assertEquals( "Producer 9", winners.get("max").get(0).getProducer());
        Assertions.assertEquals( "Producer 10", winners.get("max").get(1).getProducer());
        Assertions.assertEquals( 1, winners.get("min").get(0).getInterval());
        Assertions.assertEquals( 5, winners.get("max").get(0).getInterval());

    }

    @Test
    public void when_call_get_winners_should_be_return_empty(){
        Mockito.when(repository.findAll()).thenReturn(FilmModelBuilder.getListEmptyFilmModel());
        final Map<String, List<ResponseDTO>> winners = this.filmsService.getWinners();
        Assertions.assertEquals(winners.isEmpty(), true);
    }

}
