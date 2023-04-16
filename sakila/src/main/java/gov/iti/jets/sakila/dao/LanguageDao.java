package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.LaguageInt;
import gov.iti.jets.sakila.entities.Language;
import jakarta.persistence.*;

public class LanguageDao implements LaguageInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Language add(Language language){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(language);
        transaction.commit();
        entityManager.refresh(language);
        return language;

    }
}
