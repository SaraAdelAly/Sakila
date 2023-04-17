package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dao.ActorDao;
import gov.iti.jets.sakila.dao.FilmDao;
import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.entities.Actor;
import gov.iti.jets.sakila.entities.Category;
import gov.iti.jets.sakila.entities.Film;
import gov.iti.jets.sakila.entities.FilmActor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ActorService {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    FilmDao filmDao = new FilmDao();
    ActorDao actorDao = new ActorDao();
    private ModelMapper modelMapper = new ModelMapper();
    public ActorService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ActorDto addActor(ActorDto actorDto) {
        Actor actor = modelMapper.map(actorDto, Actor.class);
        return modelMapper.map(actorDao.addActor(actor), ActorDto.class);
    }

    public ActorDto getActorById(Integer id) {
        return modelMapper.map(actorDao.getActorById(id), ActorDto.class);
    }


    public List<ActorDto> getActorsByFilm(String title) {
        Film film = filmDao.findFilmByTitle(title);
        List<ActorDto> actorDtos = new ArrayList<>();
        List<Actor> actors = new ArrayList<>();
        for (FilmActor filmActor : film.getFilmActors()) {
            actors.add(filmActor.getActor());
        }
        for (Actor actor : actors) {
            ActorDto actorDto = modelMapper.map(actor, ActorDto.class);
            actorDtos.add(actorDto);
        }
        return actorDtos;
    }


}
