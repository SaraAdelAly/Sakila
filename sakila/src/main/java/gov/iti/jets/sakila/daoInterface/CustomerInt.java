package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.entities.Address;
import gov.iti.jets.sakila.entities.Customer;
import gov.iti.jets.sakila.entities.Store;

import java.util.List;

public interface CustomerInt {

    List<Customer> findCustomersByAddress (Integer addressId);
    Customer addCustomer (Customer customer);
    Customer findCustomerByName (String firstName, String lastName);
    Boolean getCustomerActivity (Integer customerId);
    Store getCustomerStore (Integer customerId);
    List<Customer> groupCustomersOfSameStore (Integer storeId);
    Long countCustomersByStore(Integer storeId);
}
