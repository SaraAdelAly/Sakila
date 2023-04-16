package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.entities.Actor;

import java.util.List;

public interface ActorInt {
    Actor create(Actor actor);
    Actor read(Integer id);
//    ActorDto update(Actor actor);
//    void delete(Integer id);
//    ActorDto findActorByName(String firstName, String lastName);//se puede haber mas de un actor com el mismo nombre!!!!!!!!!
    List <Actor> getActorsByFilm(String filmName);




}
