package gov.iti.jets.sakila.persistance.dao;

import gov.iti.jets.sakila.persistance.daoInterface.StaffInt;
import gov.iti.jets.sakila.persistance.entities.Staff;
import jakarta.persistence.*;

import java.util.List;

public class StaffDao implements StaffInt {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Staff getStaffById (int staffId){
        String jpql = "SELECT s FROM Staff s WHERE s.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Staff) query.getSingleResult();
    }
    public List<Staff> getAllStaff (){
        String jpql = "SELECT s FROM Staff s";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }
    public Staff addStaff (Staff staff){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(staff);
        transaction.commit();
        entityManager.refresh(staff);
        entityManager.close();
        return staff;
    }
    public void deleteStaffById (int staffId){
        String jpql = "DELETE s FROM Staff s WHERE s.id = :staffId";
        Query query = entityManager.createQuery(jpql, Staff.class);
        query.setParameter("staffId", staffId);
        query.executeUpdate();

    }

}
