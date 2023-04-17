package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.entities.Category;
import gov.iti.jets.sakila.entities.Film;
import jakarta.persistence.*;

import java.util.Set;

public class CategoryDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Category getFilmCategory (String title){

        String jpql="SELECT cf.category FROM FilmCategory cf JOIN cf.film f WHERE f.title =: title";
        Query query = entityManager.createQuery(jpql, Category.class);
        query.setParameter("title", title);
        return (Category) query.getSingleResult();
    }
    public Category addCategory (Category category){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();
        entityManager.refresh(category);
        return category;
    }

}
