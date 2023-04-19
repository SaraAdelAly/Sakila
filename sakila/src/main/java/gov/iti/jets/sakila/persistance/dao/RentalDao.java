package gov.iti.jets.sakila.persistance.dao;

import gov.iti.jets.sakila.persistance.daoInterface.RentalInt;
import gov.iti.jets.sakila.persistance.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class RentalDao implements RentalInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Staff findStaffByRentId(int rentalId) {
        String jpql = "SELECT r.staff FROM Rental r WHERE r.id= :rentalId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("rentalId", rentalId);
        return (Staff) query.getSingleResult();
    }

    @Override
    public Long getRentalOperationNumByStaffId(int staffId) {
        String jpql = "SELECT COUNT (r) FROM Rental r WHERE r.staff.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long getRentalOperationsNumByDateNdStaff(int staffId, int year,  int month, int day) {
        String jpql = "SELECT COUNT (r) FROM Rental r WHERE r.staff.id= :staffId AND YEAR(r.rentalDate) = :year AND MONTH(r.rentalDate) = :month AND DAY(r.rentalDate)= :day";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        query.setParameter("year", year);
        query.setParameter("month",month);
        query.setParameter("day",day);
        return (Long) query.getSingleResult();
    }

    public Long getRentalOperationsNumByMonthNdStaff(int staffId, int year,  int month) {
        String jpql = "SELECT COUNT (r) FROM Rental r WHERE r.staff.id= :staffId AND YEAR(r.rentalDate) = :year AND MONTH(r.rentalDate) = :month";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        query.setParameter("year", year);
        query.setParameter("month",month);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long getRentalOperationsNumByDate(int year,  int month) {
        String jpql = "SELECT COUNT (r) FROM Rental r WHERE YEAR(r.rentalDate) = :year AND MONTH(r.rentalDate) = :month";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("year", year);
        query.setParameter("month",month);
        return (Long) query.getSingleResult();
    }
    @Override
    public Long getRentalOperationsNumByDay(int year,  int month, int day){
        String jpql = "SELECT COUNT (r) FROM Rental r WHERE YEAR(r.rentalDate) = :year AND MONTH(r.rentalDate) = :month AND DAY(r.rentalDate)= :day";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("year", year);
        query.setParameter("month",month);
        query.setParameter("day",day);
        return (Long) query.getSingleResult();
    }
    @Override
    public List<Rental> getRentalOperationsOfCustomer(int customerId) {
        String jpql = "SELECT r FROM Rental r WHERE r.customer.id= :customerId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Override
    public Customer findCustomerByRentalId(int rentalId) {
        String jpql = "SELECT r.customer FROM Rental r WHERE r.id= :rentalId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("rentalId", rentalId);
        return (Customer)query.getSingleResult();
    }

    @Override
    public Inventory findInventoryByRentalId(int rentalId) {
        String jpql = "SELECT r.inventory FROM Rental r WHERE r.id= :rentalId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("rentalId", rentalId);
        return (Inventory)query.getSingleResult();
    }

    @Override
    public Film getRentedFilm(int rentalId) {
        String jpql = "SELECT r.inventory.film FROM Rental r WHERE r.id= :rentalId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("rentalId", rentalId);
        return (Film)query.getSingleResult();
    }

    @Override
    public Store getStoreOfRentedFilm(int rentalId) {
        String jpql = "SELECT r.inventory.store FROM Rental r WHERE r.id= :rentalId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("rentalId", rentalId);
        return (Store)query.getSingleResult();
    }
}
