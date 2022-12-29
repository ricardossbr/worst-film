package br.com.golden.raspberry.awards.worstfilm.controller;

import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import br.com.golden.raspberry.awards.worstfilm.service.FilmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmsController {
    private final FilmsService service;

    @GetMapping(value = "/getup")
    public ResponseEntity getUp(){
        try {
            service.saveFilmInDatabase();
        }catch (Exception e){

        }
        final List<FilmModel> films = this.service.getFilms();
        return ResponseEntity.ok(films);
    }
}
