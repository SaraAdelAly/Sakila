package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.Film;
import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.LanguageDto;
import jakarta.persistence.*;

import java.util.List;

public class FilmDao implements Film {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public List<FilmDto> findFilmsByActorName(String actorFirstName, String actorLastName) {

        try {
            String jpql = "SELECT fa.film FROM FilmActor fa JOIN fa.actor a WHERE a.firstName = :actorFirstName AND a.lastName = :actorLastName";
            Query query = entityManager.createQuery(jpql, List.class);
            query.setParameter("actorFirstName", actorFirstName);
            query.setParameter("actorLastName", actorLastName);

            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<FilmDto> findAllFilmsSameCateg (String categoryName) {

        String jpql = "SELECT fa.film FROM FilmCategory fc JOIN fc.category c WHERE c.name = : categoryName";
        Query query = entityManager.createQuery(jpql, List.class);
        query.setParameter("categoryName", categoryName);
        return query.getResultList();
    }

    public FilmDto findFilmByTitle(String title) {
        String jpql = "SELECT f FROM Film f WHERE f.title =: title";
        Query query = entityManager.createQuery(jpql, FilmDto.class);
        query.setParameter("title", title);
        return (FilmDto) query.getSingleResult();
    }

    public FilmDto add(FilmDto film) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(film);
        transaction.commit();
        entityManager.refresh(film);
        return film;
    }

    public void deleteById(FilmDto film, Integer id) {
        EntityTransaction transaction = entityManager.getTransaction();
        film = entityManager.find(FilmDto.class, id);
        transaction.begin();
        if (film != null) {
            entityManager.remove(film);
            transaction.commit();
        }
    }

    public List<FilmDto> findFilmByOriginalLanguage(LanguageDto originalLanguage) {
        TypedQuery<FilmDto> query = entityManager.createQuery("SELECT f FROM Film f WHERE f.originalLanguage = :language", FilmDto.class);
        query.setParameter("language", originalLanguage);
        return query.getResultList();
    }

    public List<FilmDto> findFilmByLanguage(LanguageDto language) {

        String jpql = "SELECT f FROM Film f WHERE f.language = :language";
        Query query = entityManager.createQuery(jpql, FilmDto.class);
        query.setParameter("language", language);
        return query.getResultList();
    }

    public FilmDto findFilmById(Integer id) {
        String jpql = "SELECT f FROM Film f WHERE f.id =: id";
        Query query = entityManager.createQuery(jpql, FilmDto.class);
        query.setParameter("id", id);
        return (FilmDto) query.getSingleResult();
    }


}
