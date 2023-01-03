package br.com.golden.raspberry.awards.worstfilm.controller;

import br.com.golden.raspberry.awards.worstfilm.dto.ResponseDTO;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import br.com.golden.raspberry.awards.worstfilm.service.FilmsService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FilmsController {

    private final FilmsService service;
    @GetMapping(value = "/up")
    public void init() throws NoSuchFileCSVException {
        try {
          this.service.saveFilmInDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/worst-film")
    public ResponseEntity getWinners(){
        final Map<String, List<ResponseDTO>> response =  this.service.getWinners();
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }
}
