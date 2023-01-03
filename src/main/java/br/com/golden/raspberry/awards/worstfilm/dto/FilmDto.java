package br.com.golden.raspberry.awards.worstfilm.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FilmDto implements Comparable<FilmDto>{
    @CsvBindByPosition(position = 0)
    private String year;
    @CsvBindByPosition(position = 1)
    private String title;
    @CsvBindByPosition(position = 2)
    private String studio;
    @CsvBindByPosition(position = 3)
    private String producer;
    @CsvBindByPosition(position = 4)
    private String winner;

    public boolean getWinner() {
        return winner.equalsIgnoreCase("yes");
    }

    @Override
    public int compareTo(FilmDto film) {
        final int  yearFilm  = Integer.parseInt(film.getYear());
        final int  year  = Integer.parseInt(this.year);
        if(year == yearFilm){
            return 0;
        }else if(year > yearFilm){
            return 1;
        }
        return -1;
    }
}
