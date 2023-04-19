package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.persistance.dao.CustomerDao;
import gov.iti.jets.sakila.dto.CustomerDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.persistance.entities.Customer;
import gov.iti.jets.sakila.persistance.entities.Store;
import gov.iti.jets.sakila.services.CustomerServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
@WebService
public class CustomerWebServices {
    CustomerServices customerServices = new CustomerServices(new ModelMapper(), new CustomerDao());

    @WebMethod(operationName = "addNewCustomer")
    public CustomerDto addCustomer(@WebParam(name = "customer") CustomerDto customerDto) {
        return customerServices.addCustomer(customerDto);
    }

    @WebMethod(operationName = "customerByAddress")
    public List<CustomerDto> findCustomersByAddress(@WebParam(name = "addressId") Integer addressId) {
        return customerServices.findCustomersByAddress(addressId);
    }

    @WebMethod(operationName = "customerByName")
    public CustomerDto findCustomerByName(@WebParam(name = "actorFirstName") String firstName, @WebParam(name = "actorLastName") String lastName) {
        return customerServices.findCustomerByName(firstName, lastName);
    }

    @WebMethod(operationName = "customerStore")
    public StoreDto getCustomerStore(@WebParam(name = "customerId") Integer customerId) {
        return customerServices.getCustomerStore(customerId);

    }

    @WebMethod(operationName = "storeCustomers")
    public List<CustomerDto> groupCustomersOfSameStore(@WebParam(name = "storeId") Integer storeId) {
        return customerServices.groupCustomersOfSameStore(storeId);
    }

    @WebMethod(operationName = "customersNumberOfStore")
    public Long countCustomersByStore(@WebParam(name = "storeId") Integer storeId) {
        return customerServices.countCustomersByStore(storeId);
    }

    @WebMethod(operationName = "checkCustomerActivity")
    public Boolean getCustomerActivity(@WebParam(name = "customerId") Integer customerId) {
        return customerServices.getCustomerActivity(customerId);
    }


}
