package gov.iti.jets.sakila.daoInterface;

//import gov.iti.jets.sakila.dto.FilmDto;
//import gov.iti.jets.sakila.dto.LanguageDto;

import gov.iti.jets.sakila.entities.Film;
import gov.iti.jets.sakila.entities.Language;

import java.util.List;
import java.util.Set;

public interface FilmInt {

    Film add(Film film);

    void deleteById(Film film, Integer id);

    Set<Film> findAllFilmsSameCateg(String categoryName);

//    List<Film> findFilmsByActorName(String actorFirstName, String actorLastName);

    Film findFilmByTitle(String title);

    Film findFilmById(Integer id);

    List<Film> findFilmByOriginalLanguage(Language originalLanguage);

    List<Film> findFilmByLanguage(Language language);


//    Film giveRatingToFilm (String rating);

    //    Film updateFilm (Film film);
//    Film read (Film film);


}
