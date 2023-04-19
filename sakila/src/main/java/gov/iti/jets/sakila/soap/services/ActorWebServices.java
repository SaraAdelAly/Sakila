package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.persistance.dao.ActorDao;
import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.services.ActorServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

import java.util.List;

@WebService
public class ActorWebServices {
    ActorServices actorServices = new ActorServices(new ModelMapper(), new ActorDao());

    @WebMethod(operationName = "addActor")
    public ActorDto addActor(@WebParam(name= "actor") ActorDto actorDto) {
        return actorServices.addActor(actorDto);
    }
    @WebMethod(operationName = "actorById")
    public ActorDto getActorById(@WebParam(name = "actorId") int id) {
        return actorServices.getActorById(id);
    }
    @WebMethod(operationName = "filmActors")
    public List<ActorDto> getActorsByFilm(@WebParam(name = "filmTitle") String title) {
        return actorServices.getActorsByFilm(title);
    }
}
