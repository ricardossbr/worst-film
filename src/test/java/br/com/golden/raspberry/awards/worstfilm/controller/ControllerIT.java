package br.com.golden.raspberry.awards.worstfilm.controller;

import br.com.golden.raspberry.awards.worstfilm.builder.FilmModelBuilder;
import br.com.golden.raspberry.awards.worstfilm.dto.ResponseDTO;
import br.com.golden.raspberry.awards.worstfilm.repository.FilmRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class ControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private FilmRepository repository;


    @Test
    @DisplayName("Call worst film with successful ")
    public void should_be_call_worst_film_with_return_ok(){
        FilmModelBuilder.getListFilmModel().stream().forEach(r -> this.repository.save(r));
        //final List<FilmModel> winnersFilms = this.repository.findAll();

        final Map<String, List<ResponseDTO>> body = this.testRestTemplate.exchange("/worst-film", HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, List<ResponseDTO>>>() {
        }).getBody();

        Assertions.assertFalse(body.isEmpty());
        Assertions.assertEquals( "Producer 2", body.get("min").get(0).getProducer());
        Assertions.assertEquals( "Producer 3", body.get("min").get(1).getProducer());
        Assertions.assertEquals( "Producer 9", body.get("max").get(0).getProducer());
        Assertions.assertEquals( "Producer 10", body.get("max").get(1).getProducer());
        Assertions.assertEquals( 1, body.get("min").get(0).getInterval());
        Assertions.assertEquals( 5, body.get("max").get(0).getInterval());
    }
}
