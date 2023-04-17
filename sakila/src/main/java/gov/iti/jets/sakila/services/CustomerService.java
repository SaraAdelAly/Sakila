package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dao.AddressDao;
import gov.iti.jets.sakila.dao.CustomerDao;
import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.dto.CustomerDto;
import gov.iti.jets.sakila.entities.Address;
import gov.iti.jets.sakila.entities.Customer;
import gov.iti.jets.sakila.entities.Store;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private ModelMapper modelMapper = new ModelMapper();
    public CustomerService(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CustomerDao customerDao = new CustomerDao();
    public CustomerDto addCustomer (CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerDao.addCustomer(customer), CustomerDto.class);

    }

    public List<CustomerDto> findCustomersByAddress(Integer addressId) {
        List<Customer> customers = customerDao.findCustomersByAddress(addressId);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }


    public CustomerDto findCustomerByName(String firstName, String lastName) {
        Customer customer = customerDao.findCustomerByName(firstName, lastName);
        return modelMapper.map(customer,CustomerDto.class);
    }



    public Store getCustomerStore(Integer customerId) {
        String jpql = "SELECT c.store FROM Customer c WHERE c.id= :customerId";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customerId", customerId);
        return (Store) query.getSingleResult();

    }

    public List<Customer> groupCustomersWithSameStore(Integer storeId) {
        String jpql = "SELECT c FROM Customer c WHERE c.store.id = :storeId ";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("storeId", storeId);
        return query.getResultList();

    }

}
