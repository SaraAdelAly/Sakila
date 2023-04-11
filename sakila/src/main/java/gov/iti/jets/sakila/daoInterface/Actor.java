package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.dto.FilmActorDto;

import java.util.List;

public interface Actor {
    ActorDto create(ActorDto actor);
    ActorDto read(Integer id);
//    ActorDto update(ActorDto actor);
//    void delete(Integer id);
//    ActorDto findActorByName(String firstName, String lastName);//se puede haber mas de un actor com el mismo nombre!!!!!!!!!
    List <Actor> getActorsByFilm(String filmName);




}
