package gov.iti.jets.sakila.persistance.daoInterface;

import gov.iti.jets.sakila.persistance.entities.Staff;

import java.util.List;

public interface StaffInt {
    Staff getStaffById(int staffId);
    List<Staff> getAllStaff();
    Staff addStaff(Staff staff);
    void deleteStaffById(int staffId);

}
