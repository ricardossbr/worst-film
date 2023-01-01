package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import br.com.golden.raspberry.awards.worstfilm.mapper.FilmMapper;
import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import br.com.golden.raspberry.awards.worstfilm.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class FilmsService {

    private final ResourcesService resourcesService;
    private final FilmRepository repository;


    public List<FilmModel>  saveFilmInDatabase(){
       try {
           final List<FilmDto> filmDto = resourcesService.getFilmDtoFromCSV();
           final List<FilmModel> filmsModel = new ArrayList<>();
           filmDto.stream()
                   .parallel()
                   .forEach(dto -> {
                       //log.info("Current film being saved in database: " + dto);
                       filmsModel.add(saveFilm(FilmMapper.INSTANCE.toFilmModel(dto)));

                   });
           getFilmWithInterval();
           return filmsModel;
       }catch (NoSuchFileCSVException e){
           e.printStackTrace();
           return null;
       }

    }

    public Map<String, FilmModel> getFilmWithInterval(){
        final List<FilmModel> films = this.repository.findByWinner(true);

        for(FilmModel film : films){
            final List<FilmModel> collect = films.stream().filter(r -> !r.equals(film) && r.getYear().equals(film.getYear()) )
                    .collect(Collectors.toList());
            collect.stream().forEach(log::info);
        }

        //
        //films.stream().forEach(log::info);
        //films.stream().forEach(log::info);
        return null;
    }

    private FilmModel saveFilm(FilmModel film) {
        return this.repository.save(film);
    }

    public List<FilmModel> getFilms(){
        return this.repository.findAll();
    }

}
