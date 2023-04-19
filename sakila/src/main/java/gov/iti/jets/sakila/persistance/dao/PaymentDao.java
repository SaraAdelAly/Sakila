package gov.iti.jets.sakila.persistance.dao;

import gov.iti.jets.sakila.persistance.daoInterface.PaymentInt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PaymentDao implements PaymentInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Long countPaymentByStaffId(int staffId) {
        String jpql = "SELECT COUNT (p) FROM Payment p WHERE p.staff.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countPaymentAmountByStaffId(int staffId) {
        String jpql = "SELECT COUNT (p.amount) FROM Payment p WHERE p.staff.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countPaymentAmountByStaffINdDate(int staffId, int year, int month) {
        String jpql = "SELECT COUNT (p.amount) FROM Payment p WHERE p.staff.id= :staffId AND YEAR(p.paymentDate) = :year AND MONTH(p.paymentDate) = :month";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        query.setParameter("year", year);
        query.setParameter("month",month);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long getCustomerPaymentOperationNum(int customerId) {
        String jpql = "SELECT COUNT (p) FROM Payment p WHERE p.customer.id= :customerId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("customerId", customerId);
        return (Long) query.getSingleResult();
    }
}
