package br.com.golden.raspberry.awards.worstfilm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FILMS_TABLE")
@Data
public class FilmModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "FILM_YEAR")
    private String year;
    private String title;
    private String studio;
    private String producer;
    private boolean winner;
}
