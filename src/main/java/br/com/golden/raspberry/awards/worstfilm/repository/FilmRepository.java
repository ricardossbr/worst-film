package br.com.golden.raspberry.awards.worstfilm.repository;

import br.com.golden.raspberry.awards.worstfilm.model.FilmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository  extends JpaRepository<FilmModel, Long> {
}
