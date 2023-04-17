package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dao.StoreDao;
import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.entities.Address;
import gov.iti.jets.sakila.entities.Staff;
import gov.iti.jets.sakila.entities.Store;
import org.modelmapper.ModelMapper;

public class StoreMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    StoreDao storeDao = new StoreDao();
    public StoreDto getStoreByManagerName(String firstName, String lastName) {
        Store store = storeDao.getStoreByManagerName(firstName, lastName);
        return modelMapper.map(store, StoreDto.class);
    }
    public AddressDto getStoreAddressById(int storeId) {
        Address address = storeDao.getStoreAddressById(storeId);
        return modelMapper.map(address, AddressDto.class);
    }
    public StaffDto getStaffByStoreId(int storeId) {
        Staff staff = storeDao.getStaffByStoreId(storeId);
        return modelMapper.map(staff, StaffDto.class);
    }

}
