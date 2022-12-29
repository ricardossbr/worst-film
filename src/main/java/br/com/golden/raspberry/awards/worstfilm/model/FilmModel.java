package br.com.golden.raspberry.awards.worstfilm.model;


import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FILMS_TABLE")
@Data
public class FilmModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "`filmYear`")
    private String year;
    private String filmName;
    private String studio;
    private String directors;
    private boolean worstFilmWinner;

    public FilmModel (FilmDto dto){
        this.year = dto.getYear();
        this.filmName = dto.getFilmName();
        this.studio = dto.getStudio();
        this.directors = dto.getDirectors();
        this.worstFilmWinner = dto.getWorstFilmWinner();
    }
}
