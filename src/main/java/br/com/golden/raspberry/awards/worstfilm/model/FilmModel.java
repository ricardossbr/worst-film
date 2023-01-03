package br.com.golden.raspberry.awards.worstfilm.model;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FILMS_TABLE")
@Data
@Builder
public class FilmModel implements Comparable<FilmModel>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "FILM_YEAR")
    private LocalDate year;
    private String title;
    private String studio;
    private String producer;
    private boolean winner;
    public void setYear(String year){
        final DateTimeFormatter format = new DateTimeFormatterBuilder()
                .appendPattern("yyyy")
                .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter();
        this.year = LocalDate.parse(year, format);
    }
    @Override
    public int compareTo(FilmModel film) {
        return this.getYear().compareTo(film.getYear());
    }
}
