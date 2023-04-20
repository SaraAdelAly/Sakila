package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.persistence.dao.StoreDao;
import gov.iti.jets.sakila.services.StoreServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

@WebService
public class StoreWebServices {
    StoreServices storeServices = new StoreServices(new ModelMapper(), new StoreDao());

    @WebMethod(operationName = "storeByManagerName")
    public StoreDto getStoreByManagerName(@WebParam(name = "actorFirstName") String firstName, @WebParam(name = "actorLastName") String lastName) {
        return storeServices.getStoreByManagerName(firstName, lastName);
    }

    @WebMethod(operationName = "AddressByStore")
    public AddressDto getStoreAddressById(@WebParam(name = "storeId") int storeId) {
        return storeServices.getStoreAddressById(storeId);
    }

    @WebMethod(operationName = "staffByStore")
    public StaffDto getStaffByStoreId(@WebParam(name = "storeId") int storeId) {
        return storeServices.getStaffByStoreId(storeId);
    }

}
