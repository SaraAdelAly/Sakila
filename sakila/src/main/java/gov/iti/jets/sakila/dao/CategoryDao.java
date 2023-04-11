package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.dto.CategoryDto;
import jakarta.persistence.*;

public class CategoryDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CategoryDto getFilmCategory (String title){

        String jpql="SELECT cf.category FROM FilmCategory cf JOIN cf.film f WHERE f.title =: title";
        Query query = entityManager.createQuery(jpql, CategoryDto.class);
        query.setParameter("title", title);
        return (CategoryDto) query.getSingleResult();
    }
    public CategoryDto add (CategoryDto category){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();
        entityManager.refresh(category);
        return category;
    }


}
