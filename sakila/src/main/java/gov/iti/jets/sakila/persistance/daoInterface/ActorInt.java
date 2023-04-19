package gov.iti.jets.sakila.persistance.daoInterface;

import gov.iti.jets.sakila.persistance.entities.Actor;

import java.util.List;

public interface ActorInt {
    Actor addActor (Actor actor);
    Actor getActorById(int id);
    List <Actor> getActorsByFilm(String filmName);




}
