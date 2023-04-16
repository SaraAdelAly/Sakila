package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.FilmInt;
import gov.iti.jets.sakila.entities.Film;
import gov.iti.jets.sakila.entities.Language;
import gov.iti.jets.sakila.entities.Rating;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmDao implements FilmInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


//    public List<Film> findFilmsByActorName(String actorFirstName, String actorLastName) {
//
//        try {
//            String jpql = "SELECT fa.film FROM FilmActor fa JOIN fa.actor a WHERE a.firstName = :actorFirstName AND a.lastName=:actorLastName";
//            Query query = entityManager.createQuery(jpql, List.class);
//            query.setParameter("actorFirstName", actorFirstName);
//            query.setParameter("actorLastName", actorLastName);
//
//            return query.getResultList();
//        } finally {
//            entityManager.close();
//        }
//    }

    public Set<Film> findAllFilmsSameCateg (String categoryName) {

        String jpql = "SELECT fc.film FROM FilmCategory fc JOIN fc.category c WHERE c.name = : categoryName";
        Query query = entityManager.createQuery(jpql, List.class);
        query.setParameter("categoryName", categoryName);
        List<Film> resultList = query.getResultList();
        Set<Film> resultSet = new HashSet<>();
        resultSet.addAll(resultList);
        return resultSet;

    }

    public Film findFilmByTitle(String title) {
        String jpql = "SELECT f FROM Film f WHERE f.title =: title";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("title", title);
        return (Film) query.getSingleResult();
    }

    public Film add(Film film) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(film);
        transaction.commit();
        entityManager.refresh(film);
        return film;
    }

    public void deleteById(Film film, Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        film = entityManager.find(Film.class, id);
        transaction.begin();
        if (film != null) {
            entityManager.remove(film);
            transaction.commit();
        }
    }

    public List<Film> findFilmByOriginalLanguage(Language originalLanguage) {
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM Film f WHERE f.originalLanguage = :language", Film.class);
        query.setParameter("language", originalLanguage);
        return query.getResultList();
    }

    public List<Film> findFilmByLanguage(Language language) {

        String jpql = "SELECT f FROM Film f WHERE f.language = :language";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("language", language);
        return query.getResultList();
    }

    public Film findFilmById(Integer id) {
        String jpql = "SELECT f FROM Film f WHERE f.id =: id";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("id", id);
        return (Film) query.getSingleResult();
    }

//    public Film setRating (Rating rating){
//        String jpql = "SELECT f FROM Film f JOIN FETCH f.rating r WHERE f.id = :filmId";
//    }


}
