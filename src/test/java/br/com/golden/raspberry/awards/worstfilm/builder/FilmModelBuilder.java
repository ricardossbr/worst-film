package br.com.golden.raspberry.awards.worstfilm.builder;

import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FilmModelBuilder {

    public static FilmModel getFilmModel(){
        return FilmModel.builder()
                .year(LocalDate.ofYearDay(1980,1))
                .title("Can't Stop the Music")
                .studio("Associated Film Distribution")
                .producer("Allan Carr")
                .winner(true)
                .build();
    }

    public static List<FilmModel> getListEmptyFilmModel(){
        return Arrays.asList();
    }
    public static List<FilmModel> getListFilmModel(){
        return Arrays.asList(
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1991,1))
                        .title("film 1")
                        .studio("Studios 1")
                        .producer("Producer 1")
                        .winner(false)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1992,1))
                        .title("Film 2")
                        .studio("Studios 2")
                        .producer("Producer 2")
                        .winner(true)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1992,1))
                        .title("Film 3")
                        .studio("Studios 3")
                        .producer("Producer 3")
                        .winner(true)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1993,1))
                        .title("Film 4")
                        .studio("Studios 4")
                        .producer("Producer 4")
                        .winner(false)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1994,1))
                        .title("Film 5")
                        .studio("Studios 5")
                        .producer("Producer 5")
                        .winner(false)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1995,1))
                        .title("Film 6")
                        .studio("Studios 6")
                        .producer("Producer 6")
                        .winner(false)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1996,1))
                        .title("Film 7")
                        .studio("Studios 7")
                        .producer("Producer 7")
                        .winner(false)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1997,1))
                        .title("Film 8")
                        .studio("Studios 8")
                        .producer("Producer 8")
                        .winner(false)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1998,1))
                        .title("Film 9")
                        .studio("Studios 9")
                        .producer("Producer 9")
                        .winner(true)
                        .build(),
                FilmModel.builder()
                        .year(LocalDate.ofYearDay(1998,1))
                        .title("Film 10")
                        .studio("Studios 10")
                        .producer("Producer 10")
                        .winner(true)
                        .build()
        );
    }
}
