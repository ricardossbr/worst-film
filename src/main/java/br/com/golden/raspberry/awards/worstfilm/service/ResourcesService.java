package br.com.golden.raspberry.awards.worstfilm.service;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import br.com.golden.raspberry.awards.worstfilm.exception.NoSuchFileCSVException;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class ResourcesService {
    @Value("${file}")
    private String fileName;
    public List<FilmDto> getFilmDtoFromCSV() throws NoSuchFileCSVException {
        try {
            final File file = new File(fileName);
            final File[] arquivos = file.listFiles();
            if(Objects.isNull(arquivos)) throw new NoSuchFileCSVException();
            final List<FilmDto> filmDtos = new ArrayList<>();
            for (int i = 0; i < arquivos.length; i++){
                if(arquivos[i].getName().contains(".csv")){
                    filmDtos.addAll(new CsvToBeanBuilder(new FileReader(arquivos[i]))
                            .withSeparator(';')
                            .withType(FilmDto.class)
                            .build()
                            .parse());
                } else{
                    log.info("This file is not cvs: {}", arquivos[i]);
                }
            }
            return filmDtos;

        } catch (FileNotFoundException e) {
            throw new NoSuchFileCSVException();
        }
    }
}
