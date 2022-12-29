package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import br.com.golden.raspberry.awards.worstfilm.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmsService {
    private final ResourcesService resourcesService;
    private final FilmRepository repository;

    public void saveFilmInDatabase(){
        final List<FilmDto> filmDto = resourcesService.getFilmDtoFromCSV();
        filmDto.stream()
                .parallel()
                .forEach(dto -> {
                    this.repository.save(new FilmModel(dto));
                });
    }

    public List<FilmModel> getFilms(){
        return this.repository.findAll();
    }

}
