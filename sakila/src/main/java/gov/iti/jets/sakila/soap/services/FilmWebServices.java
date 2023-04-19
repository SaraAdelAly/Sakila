package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.persistance.dao.FilmDao;
import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.services.FilmServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;

@WebService
public class FilmWebServices {

    FilmServices filmServices = new FilmServices(new ModelMapper(), new FilmDao());
    @WebMethod(operationName = "actorFilms")
    public List<FilmDto> findFilmsByActorName(@WebParam(name ="actorFirstName") String actorFirstName, @WebParam(name ="actorLastName") String actorLastName) {
        return filmServices.findFilmsByActorName(actorFirstName,actorLastName);
    }
    @WebMethod(operationName = "categoryFilms")
    public Set<FilmDto> findAllFilmsSameCateg(@WebParam(name= "categoryName") String categoryName) {
        return filmServices.findAllFilmsSameCateg(categoryName);
    }
    @WebMethod(operationName = "filmByTitle")
    public FilmDto findFilmByTitle(@WebParam(name= "filmTitle")String title) {
        return filmServices.findFilmByTitle(title);
    }
    @WebMethod(operationName = "addNewFilm")
    public FilmDto addFilm (@WebParam(name= "film") FilmDto filmDto) {
        return filmServices.addFilm(filmDto);
    }
    @WebMethod(operationName = "deleteFilm")
    public void deleteFilmById(@WebParam(name = "filmId") Integer id) {
        filmServices.deleteFilmById(id);
    }
    @WebMethod(operationName = "filmsByOriginalLanguageDto")
    public List<FilmDto> findFilmByOriginalLanguage(@WebParam(name ="language") LanguageDto originalLanguageDto) {
        return filmServices.findFilmByOriginalLanguage(originalLanguageDto);
    }
    @WebMethod(operationName = "filmsCategoryNumber")
    public Long countFilmsSameCategory (@WebParam(name ="categoryId") int categoryId) {

        return filmServices.countFilmsSameCategory(categoryId);
    }
    @WebMethod(operationName = "filmsByLanguages")
    public List<FilmDto> findFilmsByLanguageId(@WebParam(name ="languageId")int languageId) {
        return filmServices.findFilmsByLanguageId(languageId);
    }

    @WebMethod(operationName = "filmById")
    public FilmDto findFilmById(@WebParam(name ="filmId") Integer id) {
        return filmServices.findFilmById(id);
    }
}
