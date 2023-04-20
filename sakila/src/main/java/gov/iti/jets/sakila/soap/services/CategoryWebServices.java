package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.dto.CategoryDto;
import gov.iti.jets.sakila.persistence.dao.CategoryDao;
import gov.iti.jets.sakila.persistence.entities.Category;
import gov.iti.jets.sakila.services.CategoryServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

@WebService
public class CategoryWebServices {
    CategoryServices categoryServices = new CategoryServices(new ModelMapper(), new CategoryDao());

    @WebMethod(operationName = "filmCategory")
    public CategoryDto getFilmCategory (@WebParam(name = "filmTitle")String title){
        return categoryServices.getFilmCategory(title);
    }
    @WebMethod(operationName = "addCategory")
    public CategoryDto addCategory (@WebParam(name = "category") CategoryDto categoryDto){
       return categoryServices.addCategory(categoryDto);

    }
}
