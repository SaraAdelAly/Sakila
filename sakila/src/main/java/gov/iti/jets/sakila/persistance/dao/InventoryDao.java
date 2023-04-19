package gov.iti.jets.sakila.persistance.dao;

import gov.iti.jets.sakila.persistance.daoInterface.InventoryInt;
import gov.iti.jets.sakila.persistance.entities.Inventory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class InventoryDao implements InventoryInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Inventory> getInventoriesByFilmId(int filmId) {
        String jpql= "SELECT i FROM Inventory i WHERE i.film.id= :filmId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("filmId", filmId);
        return query.getResultList();
    }

    @Override
    public List<Inventory> getInventoriesByStoreId(int storeId) {
        String jpql= "SELECT i FROM Inventory i WHERE i.store.id= :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }

    @Override
    public Long groupFilmNumInSameStore(int storeId, int filmId) {
        String jpql = "SELECT COUNT (i.film) FROM Inventory i WHERE i.store.id= :storeId and i.film.id= :filmId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        query.setParameter("filmId", filmId);
        return (Long) query.getSingleResult();
    }

    @Override
    public Boolean checkFilmInStore(int filmId, int storeId) {
        String jpql = "SELECT COUNT (i.film)>0 FROM Inventory i WHERE i.store.id= :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return (Boolean) query.getSingleResult();
    }
}
