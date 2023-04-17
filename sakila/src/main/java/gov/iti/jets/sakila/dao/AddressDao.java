package gov.iti.jets.sakila.dao;

import gov.iti.jets.sakila.entities.Address;
import gov.iti.jets.sakila.entities.Customer;
import jakarta.persistence.*;

public class AddressDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public Address addAddress (Address adress){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(adress);
        transaction.commit();
        entityManager.refresh(adress);
        return adress;
    }

    public Address getAddressById (int addressId){
        String jpql = "SELECT a FROM Address a WHERE a.id= :addressId";
        Query query = entityManager.createQuery(jpql, Address.class);
        query.setParameter("addressId", addressId);
        return (Address) query.getSingleResult();
    }
}
