package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.daoInterface.StoreInt;
import gov.iti.jets.sakila.entities.Address;
import gov.iti.jets.sakila.entities.Staff;
import gov.iti.jets.sakila.entities.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StoreDao implements StoreInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Store getStoreByManagerName(String firstName, String lastName) {
        String jpql = "SELECT s FROM Store s WHERE s.managerStaff.firstName= :firstName AND s.managerStaff.lastName= :lastName";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return (Store) query.getSingleResult();
    }

    @Override
    public Address getStoreAddressById(int storeId) {
        String jpql = "SELECT s.address FROM Store s WHERE s.id = :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return (Address) query.getSingleResult();
    }

    @Override
    public Staff getStaffByStoreId(int storeId) {
        String jpql = "SELECT s.staff FROM Store s WHERE s.id = :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return (Staff) query.getSingleResult();
    }
}
