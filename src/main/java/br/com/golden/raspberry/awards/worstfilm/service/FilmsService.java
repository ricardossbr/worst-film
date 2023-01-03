package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import br.com.golden.raspberry.awards.worstfilm.dto.ResponseDTO;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import br.com.golden.raspberry.awards.worstfilm.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class FilmsService {

    private final ResourcesService resourcesService;
    private final FilmRepository repository;


    public void  saveFilmInDatabase() throws NoSuchFileCSVException {
           final List<FilmDto> filmDto = this.resourcesService.getFilmDtoFromCSV();
           filmDto.stream()
                   .parallel()
                   .forEach(dto -> {
                       final FilmModel film = new FilmModel();
                       film.setYear(dto.getYear());
                       film.setTitle(dto.getTitle());
                       film.setStudio(dto.getStudio());
                       film.setProducer(dto.getProducer());
                       film.setWinner(dto.getWinner());
                       this.saveFilm(film);

                   });
    }

    public Map<String, List<ResponseDTO>> getWinners(){
        final List<FilmModel> winnersFilms = this.repository.findAll();
        Collections.sort(winnersFilms);
        final List<ResponseDTO> winnersConsecutive = this.getWinnersConsecutive(winnersFilms);
        final Map<String, List<ResponseDTO>> response = new HashMap<>();
        if(winnersConsecutive.size() == 0){
            return response;
        }
        final int min = winnersConsecutive.stream().mapToInt(r -> r.getInterval()).min().getAsInt();
        final int max = winnersConsecutive.stream().mapToInt(r -> r.getInterval()).max().getAsInt();
        response.put("min",  winnersConsecutive.stream().filter(r -> r.getInterval() == min).collect(Collectors.toList()));
        response.put("max", winnersConsecutive.stream().filter(r -> r.getInterval() == max).collect(Collectors.toList()) );
        return response;
    }

    private List<ResponseDTO> getWinnersConsecutive(List<FilmModel> winnersFilms) {
        final List<ResponseDTO> response = new ArrayList<>();
        int interval = 0;
        for(int i = 0; i < winnersFilms.size(); i++){
            if((i + 1) == winnersFilms.size()) break;
            final FilmModel currentFilm = winnersFilms.get(i);
            final FilmModel followingWin = winnersFilms.get((i + 1));
            if(!currentFilm.isWinner()) {
                interval++;
                continue;
            }
            if(followingWin.isWinner()) {
                response.addAll(Arrays.asList(
                            ResponseDTO.builder()
                                    .producer(currentFilm.getProducer())
                                    .interval(interval)
                                    .previousWin(winnersFilms.get(i).getYear().getYear() - 1)
                                    .followingWin(winnersFilms.get(i).getYear().getYear() + 1 )
                                    .build(),
                            ResponseDTO.builder()
                                    .producer(followingWin.getProducer())
                                    .interval(interval)
                                    .previousWin(winnersFilms.get(i).getYear().getYear() - 1)
                                    .followingWin(winnersFilms.get(i).getYear().getYear() + 1 )
                                    .build())
                );
                interval = 0;
            }
        }
        return response;
    }

    private void saveFilm(FilmModel film) {
        this.repository.save(film);
    }

}
