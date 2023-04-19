package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.persistence.dao.AddressDao;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.services.AddressServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

@WebService
public class AddressWebServices {
    AddressServices addressServices = new AddressServices(new ModelMapper(), new AddressDao());

    @WebMethod(operationName = "addNewAddress")
    public AddressDto addAddress(@WebParam(name = "address") AddressDto addressDto) {
        return addressServices.addAddress(addressDto);
    }

    @WebMethod(operationName = "addressById")
    public AddressDto getAddressById(@WebParam(name = "addressId") int addressId) {
        return addressServices.getAddressById(addressId);
    }
}
