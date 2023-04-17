package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.LaguageInt;
import gov.iti.jets.sakila.entities.Film;
import gov.iti.jets.sakila.entities.Language;
import jakarta.persistence.*;

import java.util.List;

public class LanguageDao implements LaguageInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Language addLanguage(Language language){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(language);
        transaction.commit();
        entityManager.refresh(language);
        return language;

    }
    public Language findLanguageById(int languageId){
        String jpql = "SELECT l FROM Language l WHERE l.id = :languageId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("languageId", languageId);
        return (Language) query.getSingleResult();
    }
}
