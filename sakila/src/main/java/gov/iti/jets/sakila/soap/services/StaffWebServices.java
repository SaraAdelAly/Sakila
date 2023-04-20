package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.persistence.dao.StaffDao;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.services.StaffServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@WebService
public class StaffWebServices {
    StaffServices staffServices = new StaffServices(new ModelMapper(), new StaffDao());

    @WebMethod(operationName = "staffById")
    public StaffDto getStaffById(@WebParam(name = "staffId") int staffId) {
        return staffServices.getStaffById(staffId);
    }

    @WebMethod(operationName = "allStaffs")
    public List<StaffDto> getAllStaff() {
        return staffServices.getAllStaff();
    }

    @WebMethod(operationName = "addNewStaff")
    public StaffDto addStaff(@WebParam(name = "staff") StaffDto staffDto) {
        return staffServices.addStaff(staffDto);
    }

    @WebMethod(operationName = "deleteStaff")
    public void deleteStaffById(@WebParam(name = "staffId") int staffId) {
        staffServices.deleteStaffById(staffId);
    }

}
