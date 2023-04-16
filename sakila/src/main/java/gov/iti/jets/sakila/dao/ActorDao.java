package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.ActorInt;
//import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.entities.Actor;
import jakarta.persistence.*;

import java.util.List;

public class ActorDao implements ActorInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Actor create(Actor actor){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(actor);
        transaction.commit();
        entityManager.refresh(actor);
        return actor;
    }

    public Actor read(Integer id){
        String jpql = "SELECT a FROM Actor a WHERE a.id =: id";
        Query query = entityManager.createQuery(jpql, Actor.class);
        query.setParameter("id", id);
        return (Actor) query.getSingleResult();
    }

    public List<Actor> getActorsByFilm(String title){
        String jpql = "SELECT af.actor FROM FilmActor af JOIN af.film f WHERE f.title =: title ";
        Query query = entityManager.createQuery(jpql, Actor.class);
        query.setParameter("title", title);
        return query.getResultList();
    }










}
