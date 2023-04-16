package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.entities.Staff;

public interface RentalInt {
    Staff findStaffByRentId (int rentId);
    Long getRentalNumByStaffId (int staffId);

}
