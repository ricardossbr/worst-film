package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ResourcesServiceTest {
    @InjectMocks
    private ResourcesService resourcesService;

    @Before
    public void init(){
    }

    @Test
    public void when_call_get_film_dto_from_CSV_should_be_ok_shuld_be_ok() throws NoSuchFileCSVException {
        ReflectionTestUtils.setField(resourcesService, "fileName", "src/test/java/resources");
        final List<FilmDto>  response = this.resourcesService.getFilmDtoFromCSV();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(18, response.size());
    }

    @Test
    public void when_call_get_film_dto_from_CSV_should_be_ok_shuld_be_not_ok() {
        ReflectionTestUtils.setField(resourcesService, "fileName", "src/test/java/resources/txt");
        try{
           this.resourcesService.getFilmDtoFromCSV();
        }catch (NoSuchFileCSVException e){
            Assertions.assertEquals("Please verify the cvs file is present or the path is correct" , e.getMessage());
        }
    }

    @Test
    public void when_call_get_film_dto_from_CSV_should_be_ok_shuld_be_not_ok_because_filename_does_not_exist() {
        ReflectionTestUtils.setField(resourcesService, "fileName", "");
        try{
            this.resourcesService.getFilmDtoFromCSV();
        }catch (NoSuchFileCSVException e){
            Assertions.assertEquals("Please verify the cvs file is present or the path is correct" , e.getMessage());
        }
    }
}
