package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.entities.Actor;

import java.util.List;

public interface ActorInt {
    Actor addActor (Actor actor);
    Actor getActorById(Integer id);
    List <Actor> getActorsByFilm(String filmName);




}
