package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class ResourcesService {

    public List<FilmDto> getFilmDtoFromCSV() {
        try {
            return new CsvToBeanBuilder(new FileReader("C:\\Users\\ricar\\Downloads\\movies.csv"))
                    .withSeparator(';')
                    .withType(FilmDto.class)
                    .build()
                    .parse();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
