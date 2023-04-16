package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.entities.Address;
import gov.iti.jets.sakila.entities.Staff;
import gov.iti.jets.sakila.entities.Store;

public interface StoreInt {


    Store getStoreByManagerName (String firstName, String lastName);
    Address getStoreAddressById (int storeId);
    Staff getStaffByStoreId (int storeId);



}
