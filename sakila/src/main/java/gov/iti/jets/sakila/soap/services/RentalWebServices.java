package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.dto.*;
import gov.iti.jets.sakila.persistence.dao.RentalDao;
import gov.iti.jets.sakila.persistence.entities.*;
import gov.iti.jets.sakila.services.RentalServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
@WebService
public class RentalWebServices {
    RentalServices rentalServices = new RentalServices(new ModelMapper(), new RentalDao());

    @WebMethod(operationName = "staffByRentId")
    public StaffDto findStaffByRentId(@WebParam(name = "rentalId")int rentalId) {
        return rentalServices.findStaffByRentId(rentalId);
    }
    @WebMethod(operationName = "staffRentalOperationsNumber")
    public Long getRentalOperationNumByStaffId(@WebParam(name = "staffId")int staffId) {
        return rentalServices.getRentalOperationNumByStaffId(staffId);
    }
    @WebMethod(operationName = "staffRentalOperationsNumberByDate")
    public Long getRentalOperationsNumByDateNdStaff(@WebParam(name = "staffId")int staffId, @WebParam(name = "year")int year, @WebParam(name = "month")int month, @WebParam(name = "day")int day) {
        return rentalServices.getRentalOperationsNumByDateNdStaff(staffId, year, month, day);
    }
    @WebMethod(operationName = "staffRentalOperationsNumberByMonth")
    public Long getRentalOperationsNumByMonthNdStaff(@WebParam(name = "staffId")int staffId, @WebParam(name = "year")int year, @WebParam(name = "month")int month) {
        return rentalServices.getRentalOperationsNumByMonthNdStaff(staffId, year, month);
    }
    @WebMethod(operationName = "getRentalOperationsNumByDate")
    public Long getRentalOperationsNumByDate(@WebParam(name = "year")int year, @WebParam(name = "month")int month) {
        return rentalServices.getRentalOperationsNumByDate(year, month);
    }
    @WebMethod(operationName = "rentalOperationPerDay")
    public Long getRentalOperationsNumByDay(@WebParam(name = "year")int year, @WebParam(name = "month")int month, @WebParam(name = "day")int day) {
        return rentalServices.getRentalOperationsNumByDay(year, month, day);
    }
    @WebMethod(operationName = "getRentalOperationsOfCustomer")
    public List<RentalDto> getRentalOperationsOfCustomer(@WebParam(name = "customerId")int customerId) {
       return rentalServices.getRentalOperationsOfCustomer(customerId);
    }
    @WebMethod(operationName = "customerByRental")
    public CustomerDto findCustomerByRentalId(@WebParam(name = "rentalId")int rentalId) {
      return rentalServices.findCustomerByRentalId(rentalId);
    }
    @WebMethod(operationName = "inventoryByRental")
    public InventoryDto findInventoryByRentalId(@WebParam(name = "rentalId")int rentalId) {
       return rentalServices.findInventoryByRentalId(rentalId);
    }
    @WebMethod(operationName = "filmByRental")
    public FilmDto getRentedFilm(@WebParam(name = "rentalId")int rentalId) {
        return rentalServices.getRentedFilm(rentalId);
    }
    @WebMethod(operationName = "storeByRental")
    public StoreDto getStoreOfRentedFilm(@WebParam(name = "rentalId")int rentalId) {
       return rentalServices.getStoreOfRentedFilm(rentalId);
    }
}
