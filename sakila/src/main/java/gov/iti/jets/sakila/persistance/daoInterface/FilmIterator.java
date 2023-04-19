package gov.iti.jets.sakila.persistance.daoInterface;


import gov.iti.jets.sakila.persistance.entities.Film;

public interface FilmIterator {
    boolean hasNext();
    Film next();
}
