package br.com.golden.raspberry.awards.worstfilm.builder;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;

import java.util.Arrays;
import java.util.List;

public class FilmDtoBuilder {

    public static FilmDto getFilmDto(){
        return FilmDto.builder()
                .year("1980")
                .title("Can't Stop the Music")
                .studio("Associated Film Distribution")
                .producer("Allan Carr")
                .winner("true")
                .build();
    }

    public static List<FilmDto> getListFilmDto(){

        return Arrays.asList(
                FilmDto.builder()
                        .year("1980")
                        .title("Can't Stop the Music")
                        .studio("Associated Film Distribution")
                        .producer("Allan Carr")
                        .winner("true")
                        .build(),
                FilmDto.builder()
                        .year("1980")
                        .title("Cruising")
                        .studio("Lorimar Productions, United Artists")
                        .producer("Jerry Weintraub")
                        .winner("")
                        .build()
        );
    }


}
