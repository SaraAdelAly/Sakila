package gov.iti.jets.sakila.persistance.dao;

import gov.iti.jets.sakila.persistance.daoInterface.FilmIterator;
import gov.iti.jets.sakila.persistance.entities.Film;

import java.util.List;
import java.util.NoSuchElementException;

public class FilmIteratorImpl implements FilmIterator {
    private List <Film> films;
    private int currentPosition;

    public FilmIteratorImpl (List<Film> films){
        this.films =films;
        this.currentPosition =0;
    }
    @Override
    public boolean hasNext() {
        return currentPosition < films.size();
    }

    @Override
    public Film next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Film film = films.get(currentPosition);
        currentPosition++;
        return film;
    }
}
