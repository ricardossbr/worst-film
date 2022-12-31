package br.com.golden.raspberry.awards.worstfilm.mapper;

import br.com.golden.raspberry.awards.worstfilm.dto.FilmDto;
import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public  abstract class FilmMapper {
    public static final FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    public abstract FilmModel toFilmModel(FilmDto filmDto);
}
