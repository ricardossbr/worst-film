package br.com.golden.raspberry.awards.worstfilm.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmDto {
    @CsvBindByPosition(position = 0)
    private String year;
    @CsvBindByPosition(position = 1)
    private String filmName;
    @CsvBindByPosition(position = 2)
    private String studio;
    @CsvBindByPosition(position = 3)
    private String directors;
    @CsvBindByPosition(position = 4)
    private String worstFilmWinner;

    public boolean getWorstFilmWinner() {
        return worstFilmWinner.toLowerCase().equals("yes");
    }
}
