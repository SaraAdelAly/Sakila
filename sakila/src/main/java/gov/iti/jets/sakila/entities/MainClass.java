package gov.iti.jets.sakila.entities;

import com.mysql.cj.Query;

import gov.iti.jets.sakila.dao.*;
import gov.iti.jets.sakila.entities.enums.RatingType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass {

    
    public static void main(String[] args) {

    //     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    // EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Rating rating = new Rating();
        FilmDao filmDao = new FilmDao();
//        FilmDao filmDao1 = new FilmDao();
//        FilmDao filmDao2 = new FilmDao();
//        FilmDao filmDao3 = new FilmDao();
//        FilmDao filmDao4 = new FilmDao();
////        FilmDao filmDao5 = new FilmDao();
//
//        Film film = new Film();
//        Film film1 = new Film();
//        Film film2 = new Film();
//        Film film3 = new Film();
//        Film film4 = new Film();
//
//        film= filmDao.findFilmByTitle("ACADEMY DINOSAUR");
//        film1= filmDao1.findFilmByTitle("ACE GOLDFINGER");
//        film2 =filmDao2.findFilmByTitle("ADAPTATION HOLES");
//        film3= filmDao3.findFilmByTitle("AFFAIR PREJUDICE");
//        film4= filmDao4.findFilmByTitle("AFRICAN EGG");
//
//        List<Film> films = new ArrayList<>();
//        films.add(film1);
//        films.add(film);
//        films.add(film2);
//        films.add(film3);
//        films.add(film4);
//
//
//
//        Set<Film> resultSet = new HashSet<>();
//        resultSet.addAll(films);
//
//
//
//
//        rating.setFilms(resultSet);
//        rating.setRatingType(RatingType.G);
//        RatingDao ratingDao= new RatingDao();
//        ratingDao.add(rating);

    // String jpql = "SELECT r.id FROM Rating r WHERE r.rating =: ratingType";
    // Query query = (Query) entityManager.createQuery(jpql);
    // ((jakarta.persistence.Query) query).setParameter("ratingType", RatingType.PG_13);
    // Integer ratingId = (Integer) ((jakarta.persistence.Query) query).getSingleResult();
    


         CustomerDao customerDao = new CustomerDao();
        CategoryDao categoryDao = new CategoryDao();
        InventoryDao inventoryDao = new InventoryDao();
        StoreDao storeDao = new StoreDao();

//     System.out.println( ratingId);
//        System.out.println(filmDao.findFilmByLanguageId(1));
        System.out.println(storeDao.getStoreByManagerName("Mike","Hillyer"));
//        System.out.println(filmDao.findFilmByTitle("ACADEMY DINOSAUR"));






    }
    
}
