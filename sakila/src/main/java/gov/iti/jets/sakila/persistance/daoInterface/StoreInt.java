package gov.iti.jets.sakila.persistance.daoInterface;

import gov.iti.jets.sakila.persistance.entities.Address;
import gov.iti.jets.sakila.persistance.entities.Staff;
import gov.iti.jets.sakila.persistance.entities.Store;

public interface StoreInt {


    Store getStoreByManagerName (String firstName, String lastName);
    Address getStoreAddressById (int storeId);
    Staff getStaffByStoreId (int storeId);



}
