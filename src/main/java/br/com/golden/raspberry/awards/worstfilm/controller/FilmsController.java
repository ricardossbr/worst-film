package br.com.golden.raspberry.awards.worstfilm.controller;

import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import br.com.golden.raspberry.awards.worstfilm.service.FilmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmsController {

    private final FilmsService service;

    @GetMapping(value = "/up")
    public ResponseEntity getUp(){
        try {
            final List<FilmModel> films = this.service.saveFilmInDatabase();
            return ResponseEntity.ok(films);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/worst-film")
    public ResponseEntity getWorstFilm(){

        return ResponseEntity.ok("");
    }
}
