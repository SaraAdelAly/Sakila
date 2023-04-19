package gov.iti.jets.sakila.persistance.daoInterface;

import gov.iti.jets.sakila.persistance.entities.*;

import java.util.List;

public interface RentalInt {
    Staff findStaffByRentId (int rentalId);
    Long getRentalOperationNumByStaffId (int staffId);
    Long getRentalOperationsNumByDateNdStaff(int staffId, int year,  int month, int day) ;
    Long getRentalOperationsNumByDate(int year,  int month);
    Long getRentalOperationsNumByDay(int year,  int month, int day);
    List<Rental> getRentalOperationsOfCustomer (int customerId);
    Customer findCustomerByRentalId (int rentalId);
    Inventory findInventoryByRentalId (int rentalId);
    Film getRentedFilm (int rentalId);
    Store getStoreOfRentedFilm(int rentalId);

}
