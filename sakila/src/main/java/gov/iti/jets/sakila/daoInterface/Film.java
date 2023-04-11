package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.LanguageDto;

import java.util.List;

public interface Film {

    FilmDto add(FilmDto film);

    void deleteById(FilmDto film, Integer id);

    List<FilmDto> findAllFilmsSameCateg(String categoryName);

    List<FilmDto> findFilmsByActorName(String actorFirstName, String actorLastName);

    FilmDto findFilmByTitle(String title);

    FilmDto findFilmById(Integer id);

    List<FilmDto> findFilmByOriginalLanguage(LanguageDto originalLanguage);

    List<FilmDto> findFilmByLanguage(LanguageDto language);


//    FilmDto giveRatingToFilm (String rating);

    //    FilmDto updateFilm (FilmDto film);
//    FilmDto read (FilmDto film);


}
