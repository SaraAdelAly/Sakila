package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.Actor;
import gov.iti.jets.sakila.dto.ActorDto;
import jakarta.persistence.*;

import java.util.List;

public class ActorDao implements Actor{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ActorDto create(ActorDto actor){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(actor);
        transaction.commit();
        entityManager.refresh(actor);
        return actor;
    }

    public ActorDto read(Integer id){
        String jpql = "SELECT a FROM Actor a WHERE a.id =: id";
        Query query = entityManager.createQuery(jpql, ActorDto.class);
        query.setParameter("id", id);
        return (ActorDto) query.getSingleResult();
    }

    public List<Actor> getActorsByFilm(String title){
        String jpql = "SELECT af.actor FROM FilmActor af JOIN af.film f WHERE f.title =: title ";
        Query query = entityManager.createQuery(jpql, ActorDto.class);
        query.setParameter("title", title);
        return query.getResultList();
    }








}
