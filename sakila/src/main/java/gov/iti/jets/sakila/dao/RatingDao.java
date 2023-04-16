package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.entities.Rating;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RatingDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Rating add (Rating rating1){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(rating1);
        transaction.commit();
        entityManager.refresh(rating1);
        return rating1;
    }
}
