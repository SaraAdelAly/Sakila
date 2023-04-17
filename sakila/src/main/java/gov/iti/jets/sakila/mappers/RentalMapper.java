package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dao.RentalDao;
import gov.iti.jets.sakila.dto.*;
import gov.iti.jets.sakila.entities.*;
import jakarta.persistence.Query;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class RentalMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    RentalDao rentalDao = new RentalDao();

    public StaffDto findStaffByRentId(int rentalId) {
        Staff staff = rentalDao.findStaffByRentId(rentalId);
        return modelMapper.map(staff, StaffDto.class);
    }

    public List<RentalDto> getRentalOperationsOfCustomer(int customerId) {
        List<Rental> rentals = rentalDao.getRentalOperationsOfCustomer(customerId);
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental rental : rentals) {
            RentalDto rentalDto = modelMapper.map(rental, RentalDto.class);
            rentalDtos.add(rentalDto);
        }
        return rentalDtos;
    }

    public CustomerDto findCustomerByRentalId(int rentalId) {
        Customer customer = rentalDao.findCustomerByRentalId(rentalId);
        return modelMapper.map(customer, CustomerDto.class);
    }

    public InventoryDto findInventoryByRentalId(int rentalId) {
        Inventory inventory = rentalDao.findInventoryByRentalId(rentalId);
        return modelMapper.map(inventory, InventoryDto.class);
    }

    public FilmDto getRentedFilm(int rentalId) {
        Film film = rentalDao.getRentedFilm(rentalId);
        return modelMapper.map(film, FilmDto.class);
    }

    public StoreDto getStoreOfRentedFilm(int rentalId) {
        Store store = rentalDao.getStoreOfRentedFilm(rentalId);
        return modelMapper.map(store, StoreDto.class);
    }
}
