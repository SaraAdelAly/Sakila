package gov.iti.jets.sakila.daoInterface;


import gov.iti.jets.sakila.entities.Film;

public interface FilmIterator {
    boolean hasNext();
    Film next();
}
