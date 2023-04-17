package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dao.ActorDao;
import gov.iti.jets.sakila.dao.FilmDao;
import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.entities.Actor;
import gov.iti.jets.sakila.entities.Film;
import gov.iti.jets.sakila.entities.FilmActor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ActorMapper {
    FilmDao filmDao = new FilmDao();
    ActorDao actorDao = new ActorDao();
    private ModelMapper modelMapper = new ModelMapper();

    public ActorMapper(ModelMapper modelMapper) {
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
        List <Actor> actors = actorDao.getActorsByFilm(title);
        List<ActorDto> actorDtos = new ArrayList<>();
        for (Actor actor : actors) {
            ActorDto actorDto = modelMapper.map(actor, ActorDto.class);
            actorDtos.add(actorDto);
        }
        return actorDtos;
    }


}
